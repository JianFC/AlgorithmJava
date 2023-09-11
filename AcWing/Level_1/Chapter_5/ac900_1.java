package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac900_1 {  //AcWing 900. 整数划分，解法1：完全背包问题
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 1010, mod = (int)1e9 + 7;

    static int n;
    static int[] f = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;

        f[0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j++)
                f[j] = (f[j] + f[j - i]) % mod;

        out.println(f[n]);

        out.flush();
    }
}
