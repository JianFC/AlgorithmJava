package AcWing.Level_1.Chapter_4;    //886. 求组合数 I

import java.io.*;

public class ac885 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 2010, mod = (int)1e9 + 7;
    
    static int[][] C = new int[N][N];
    
    static void init() {
        for (int i = 0; i < N; i ++)     //注意从0开始
            for (int j = 0; j <= i; j ++)    //注意从0开始
                if (j == 0) C[i][j] = 1;
                else C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % mod;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        init();
        
        while (n -- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            out.println(C[a][b]);
        }

        out.flush();
    }
}
