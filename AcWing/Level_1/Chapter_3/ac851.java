package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac851 {    //851. spfa求最短路
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = N, INF = 0x3f3f3f3f;
    
    static int n, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], w = new int[M], ne = new int[M];
    static int[] dist = new int[N];
    static int hh, tt = -1;
    static int[] q = new int[M];    //存储待更新的点
    static boolean[] st = new boolean[N];   //存储当前点是否在队列中
    
    static void add(int a, int b, int c) {
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }
    
    static int spfa() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        q[++tt] = 1;
        st[1] = true;
        
        while (hh <= tt) {
            int t = q[hh++];
            st[t] = false;
            
            for (int i=h[t]; i!=-1; i=ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t]+w[i]) {
                    dist[j] = dist[t]+w[i];
                    
                    if (!st[j]) {   //注意更新的位置
                        q[++tt] = j;
                        st[j] = true;
                    }
                }
            }
        }
        
        return dist[n];
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
        
        int t = spfa();
        out.println((t == INF ? "impossible" : t));

        out.flush();
    }
}
