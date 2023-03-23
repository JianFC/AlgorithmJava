package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac850 {    //850. Dijkstra求最短路 II
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 150010, M = N, INF = 0x3f3f3f3f;
    
    static int n, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], w = new int[M], ne = new int[M];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    
    static void add(int a, int b, int c) {
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }
    
    static int dijkstra() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        //自定义堆组织方式
        PriorityQueue<PII> heap = new PriorityQueue<PII>((o1, o2) -> o1.first-o2.first);
        heap.add(new PII(0, 1));
        
        while (!heap.isEmpty()) {
            PII t = heap.poll();
            
            int ver = t.second, d = t.first;
            
            if (st[ver]) continue;  //判断最短距离是否已经确定
            st[ver] = true;
            
            for (int i=h[ver]; i!=-1; i=ne[i]) {    //更新ver所有出边
                int j = e[i];
                if (!st[j] && dist[j] > d+w[i]) {
                    dist[j] = d+w[i];
                    heap.add(new PII(dist[j], j));
                }
            }
        }
        
        return dist[n] == INF ? -1 : dist[n];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        while (m-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            add(a, b, c);
        }
        
        out.println(dijkstra());

        out.flush();
    }
    
    static class PII {
        int first, second;
        
        PII (int f, int s) {
            first = f; second = s;
        }
    }
}
