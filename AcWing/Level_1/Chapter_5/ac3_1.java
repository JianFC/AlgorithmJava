package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac3_1 {    //3. 完全背包问题_朴素版本
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010;
    
    static int n, m;
    static int[] v = new int[N], w = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) {
            ins.nextToken(); v[i] = (int)ins.nval;
            ins.nextToken(); w[i] = (int)ins.nval;
        }
        
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++)
                for (int k = 0; k * v[i] <= j; k ++)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
        
        out.println(f[n][m]);

        out.flush();
    }
}
