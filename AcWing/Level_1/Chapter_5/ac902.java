package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac902 {    //AcWing 902. 最短编辑距离
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 1010;

    static int n, m;
    static char[] a = new char[N], b = new char[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(inb.readLine().split(" +")[0]);
        String tmp = inb.readLine(); tmp = " " + tmp; a = tmp.toCharArray();
        m = Integer.parseInt(inb.readLine().split(" +")[0]);
        tmp = inb.readLine(); tmp = " " + tmp; b = tmp.toCharArray();

        //初始化边界
        for (int i = 1; i <= m; i ++) f[0][i] = i;
        for (int i = 1; i <= n; i ++) f[i][0] = i;

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (a[i] == b[j]) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                else f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
            }

        out.println(f[n][m]);

        out.flush();
    }
}
