package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac844 {    //走迷宫
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110;
    
    static int n, m;
    static int[][] g = new int[N][N], d = new int[N][N];
    static int hh, tt = -1;
    static PII[] q = new PII[N * N];
    static PII[][] pre = new PII[N][N];
    
    static int bfs() {
        for (int i = 0; i < n; i++) Arrays.fill(d[i], -1);
        
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        
        d[0][0] = 0;
        q[++tt] = new PII(0, 0);
        
        while (hh <= tt) {
            PII t = q[hh++];
            
            for (int i = 0; i < 4; i++) {
                int x = t.first + dx[i], y = t.second + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] != 1 && d[x][y] == -1) {
                    d[x][y] = d[t.first][t.second] + 1;
                    // pre[x][y] = t;
                    q[++tt] = new PII(x, y);
                }
            }
        }
        
        // 打印路径
        // int x = n - 1, y = m - 1;
        // while (x > 0 || y > 0) {
        //     out.println(x +" "+y);
        //     PII t = pre[x][y];
        //     x = t.first; y = t.second;
        // }
        
        return d[n - 1][m - 1];
    }
 
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) { ins.nextToken(); g[i][j] = (int)ins.nval; }
        
        out.println(bfs());

        out.flush();
    }
    
    static class PII {
        int first, second;
        
        PII (int f, int s) {
            first = f; second = s;
        }
    }
}
