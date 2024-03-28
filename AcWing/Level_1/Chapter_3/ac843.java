package AcWing.Level_1.Chapter_3;       //AcWing 843. n-皇后问题

import java.io.*;

public class ac843 {    //843. n-皇后问题
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 10;
    
    static int n;
    static char[][] g = new char[N][N];
    static boolean[] col = new boolean[N], dg = new boolean[N * 2], udg = new boolean[N * 2];
    
    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) out.print(g[i][j]);
                out.println();
            }
            out.println();
            return;
        }
        
        for (int i = 0; i < n; i++)
            if (!col[i] && !dg[u + i] && !udg[u - i + n]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[u - i + n] = true;
                dfs(u+1);
                col[i] = dg[u + i] = udg[u - i + n] = false;
                g[u][i] = '.';
            }
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) g[i][j] = '.';
        
        dfs(0);

        out.flush();
    }
}
