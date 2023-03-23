package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac858 {    //AcWing 858. Prim算法求最小生成树
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 520, INF = 0x3f3f3f3f;
    
    static int n, m;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    
    static int prim() {
        Arrays.fill(dist, INF);
        
        int res = 0;
        for (int i=0; i<n; i++) {
            int t = -1;
            
            for (int j=1; j<=n; j++)
                if (!st[j] && (t == -1 || dist[j] < dist[t]))
                    t = j;
            
            if (i != 0 && dist[t] == INF) return INF;
            if (i != 0) res += dist[t];
            st[t] = true;   // 将该点加入集合
            
            for (int j=1; j<=n; j++)
                dist[j] = Math.min(dist[j], g[t][j]);
        }
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i=1; i<=n; i++) Arrays.fill(g[i], INF);
        
        while (m-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        
        int t = prim();
        out.println((t == INF ? "impossible": t));

        out.flush();
    }
}
