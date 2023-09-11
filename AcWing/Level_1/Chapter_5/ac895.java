package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac895 {    //895. 最长上升子序列
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 1010;

    static int n;
    static int[] a = new int[N], f = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;

        for (int i = 1; i <= n; i++) { ins.nextToken(); a[i] = (int)ins.nval; }

        for (int i = 1; i <= n; i++) {
            f[i] = 1;   //没有第i-1个数
            for (int j = 1; j < i; j++)
                if (a[j] < a[i]) f[i] = Math.max(f[i], f[j] + 1);
        }

        //找出答案
        int ans = 0;
        for (int i = 1; i <= n; i++) ans = Math.max(f[i], ans);

        out.println(ans);

        out.flush();
    }    
}
