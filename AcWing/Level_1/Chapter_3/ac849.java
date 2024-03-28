package AcWing.Level_1.Chapter_3;       //AcWing 849. Dijkstra求最短路 I

import java.io.*;
import java.util.*;

public class ac849 {    //849. Dijkstra求最短路 I
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 510, INF = 0x3f3f3f3f;
    
    static int n, m;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    
    static int dijkstra() {
        Arrays.fill(dist, INF);
        
        dist[1] = 0;
        
        for (int i = 0; i < n; i ++) {
            int t = -1;
            
            for (int j = 1; j <= n; j ++)
                if (!st[j] && (t == -1 || dist[j] < dist[t]))
                    t = j;
            
            st[t] = true;
            
            for (int j = 1; j <= n; j ++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
        }
        
        return dist[n] == INF ? -1 : dist[n];
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) Arrays.fill(g[i], INF);
        
        while (m-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            g[a][b] = Math.min(g[a][b], c);
        }
        
        out.println(dijkstra());

        out.flush();
    }
}
