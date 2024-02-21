package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac796 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010;
    
    static int n, m, q;
    static int[][] a = new int[N][N], s = new int[N][N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        ins.nextToken(); q = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++) { ins.nextToken(); a[i][j] = (int)ins.nval; }
        
        //初始化前缀和
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++) 
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
        
        while (q-- > 0) {
            ins.nextToken(); int x1 = (int)ins.nval;
            ins.nextToken(); int y1 = (int)ins.nval;
            ins.nextToken(); int x2 = (int)ins.nval;
            ins.nextToken(); int y2 = (int)ins.nval;
            out.println(s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]);
        }
        
        out.flush();
    }
    
}
