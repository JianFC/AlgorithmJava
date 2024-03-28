package AcWing.Level_1.Chapter_5;     //4. 多重背包问题 I_朴素版本

import java.io.*;

public class ac4 {      //4. 多重背包问题 I_朴素版本
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110;
    
    static int n, m;
    static int[] s = new int[N], v = new int[N], w = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) {
            ins.nextToken(); v[i] = (int)ins.nval;
            ins.nextToken(); w[i] = (int)ins.nval; 
            ins.nextToken(); s[i] = (int)ins.nval;
        }
        
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++)
                for (int k = 0; k <= s[i] && k * v[i] <= j; k ++)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                    
        out.println(f[n][m]);

        out.flush();
    }
}
