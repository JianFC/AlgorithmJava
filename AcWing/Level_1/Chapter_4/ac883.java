package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac883 {    //AcWing 883. 高斯消元解线性方程组
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 110; static double eps = 1e-6;

    static int n;
    static double[][] a = new double[N][N];

    static int gauss() {
        int r, c;

        for (c = 0,r = 0; c < n; c++) {
            //找出第c列绝对值最大的行t
            int t = r;
            for (int i = r; i < n; i++)
                if (Math.abs(a[i][c]) > Math.abs(a[t][c]))  t = i;

            //判断是否为0
            if (Math.abs(a[t][c]) < eps) continue;

            //将第t行与当前最上方行互换
            double[] tmp = a[r]; a[r] = a[t]; a[t] = tmp;

            //将a[r][c]置1
            for (int i = n; i >= c; i--) a[r][i] /= a[r][c];

            //将r行下所有行c列位置清0
            for (int i = r + 1; i < n; i++)
                if (Math.abs(a[i][c]) > eps)
                    for (int j = n; j >= c; j--)
                        a[i][j] -= a[i][c] * a[r][j];

            r++;    //该行处理完毕
        }

        //不是唯一解
        if (r < n) {
            for (int i = r; i < n; i++) 
                if (Math.abs(a[i][n]) > eps) return 2; 

            return 1;
        }

        //唯一解，从最后一行开始求解
        for (int i = n - 1; i >= 0; i--)
            for (int j = i + 1; j < n; j++)
                a[i][n] -= a[i][j] * a[j][n];

        return 0;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;

        //注意数据类型
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= n; j++) { ins.nextToken(); a[i][j] = (double)ins.nval; }

        int t = gauss();

        //浮点精度处理
        for (int i = 0; i < n; i++)
            if (Math.abs(a[i][n]) < eps) a[i][n] = 0;

        if (t == 0)
            for (int i = 0; i < n; i++) out.printf("%.2f\n", a[i][n]);
        else if (t == 1) out.println("Infinite group solutions");
        else out.println("No solution");

        out.flush();
    }
}
