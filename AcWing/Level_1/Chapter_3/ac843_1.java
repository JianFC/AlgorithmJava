package AcWing.Level_1.Chapter_3;

import java.io.*;

public class ac843_1 {  //843. n-皇后问题
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 10;
    
    static int n;
    static char[][] g = new char[N][N];
    static boolean[] row = new boolean[N], col = new boolean[N], dg = new boolean[N*2], udg = new boolean[N*2];
    
    static void dfs(int x, int y, int s) {
        if (y == n) {
            y = 0; x++;
        }
        
        if (x == n) {
            if (s == n) {
                for (int i=0; i<n; i++) {
                    for (int j=0; j<n; j++) out.print(g[i][j]);
                    out.println();
                }
                out.println();
            }
            return;
        }
        
        //不放皇后
        dfs(x, y+1, s);
        
        //放皇后
        if (!row[x] && !col[y] && !dg[x+y] && !udg[y-x+n]) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x+y] = udg[y-x+n] = true;
            dfs(x, y+1, s+1);
            row[x] = col[y] = dg[x+y] = udg[y-x+n] = false;
            g[x][y] = '.';
        }
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++) g[i][j] = '.';
        
        dfs(0, 0, 0);

        out.flush();
    }
}
