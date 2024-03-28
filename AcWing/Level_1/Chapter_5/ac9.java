package AcWing.Level_1.Chapter_5;    //AcWing 9. 分组背包问题

import java.io.*;

public class ac9 {  //AcWing 9. 分组背包问题
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110;
    
    static int n, m;
    static int[][] v = new int[N][N], w = new int[N][N];
    static int[] s = new int[N];
    static int[] f = new int[N];
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) {
            ins.nextToken(); s[i] = (int)ins.nval;
            
            for (int j = 1; j <= s[i]; j ++) {
                ins.nextToken(); v[i][j] = (int)ins.nval;
                ins.nextToken(); w[i][j] = (int)ins.nval;
            }
        }
        
        for (int i = 1; i <= n; i ++)
            for (int j = m; j >= 1; j --)
                for (int k = 1; k <= s[i]; k ++)
                    if (j >= v[i][k]) f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
        
        out.println(f[m]);

        out.flush();
    }
}
