package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac884 {    //884. 高斯消元解异或线性方程组
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110;
    
    static int n;
    static int[][] a = new int[N][N];
    
    static int gauss() {
        int c, r;
        
        for (c = 0, r = 0; c < n; c ++) {
            int t = r;
            for (int i = r; i < n; i ++)
                if (a[i][c] != 0) {
                    t = i; break;
                }
            
            if (a[t][c] == 0) continue;
            
            int[] tmp = a[r]; a[r] = a[t]; a[t] = tmp;
            
            for (int i = r + 1; i < n; i ++)
                if (a[i][c] != 0)
                    for (int j = n; j >= c; j --)
                        a[i][j] ^= a[r][j];
            
            r ++;
        }
        
        if (r < n) {
            for (int i = r; i < n; i ++)
                if (a[i][n] != 0) return 2;
            
            return 1;
        }
        
        for (int i = n - 1; i >= 0; i --)
            for (int j = i + 1; j < n; j ++)
                a[i][n] ^= a[i][j] * a[j][n];
        
        return 0;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++)
            for (int j = 0; j <= n; j ++) { ins.nextToken(); a[i][j] = (int)ins.nval; }
            
        int t = gauss();
        
        if (t == 0)
            for (int i = 0; i < n; i ++) out.println(a[i][n]);
        else if (t == 1) out.println("Multiple sets of solutions");
        else out.println("No solution");

        out.flush();
    }
}
