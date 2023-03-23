package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac853 {    //853. 有边数限制的最短路
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 510, M = 10010, INF = 0x3f3f3f3f;
    
    static int n, m, k;
    static Edge[] edge = new Edge[M];
    static int[] dist = new int[N], last = new int[N];
    
    static int bellmanFord() {
        Arrays.fill(dist, INF);
        
        dist[1] = 0;
        
        for (int i=0; i<k; i++) {
            last = dist.clone();    //备份上一次迭代结果，防止串联
            
            for (int j=0; j<m; j++) {
                Edge e = edge[j];
                dist[e.b] = Math.min(dist[e.b], last[e.a]+e.w);
            }
        }
        
        if (dist[n] > INF/2) return INF;
        else return dist[n];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        ins.nextToken(); k = (int)ins.nval;
        
        for (int i=0; i<m; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            edge[i] = new Edge(a, b, c);
        }
        
        int t = bellmanFord();
        out.println((t == INF? "impossible" : t));

        out.flush();
    }
    
    static class Edge {
        int a, b, w;
        
        Edge (int aa, int bb, int ww) {
            a = aa; b = bb; w = ww;
        }
    }
}
