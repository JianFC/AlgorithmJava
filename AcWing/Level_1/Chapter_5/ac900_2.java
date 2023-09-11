package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac900_2 {  //解法二
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010, mod = (int)1e9 + 7;
    
    static int n;
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        f[0][0] = 1;
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                f[i][j] = (f[i - 1][j - 1] + f[i - j][j]) % mod;
        
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = (res + f[n][i]) % mod;
        
        out.println(res);
        
        out.flush();
    }
}
