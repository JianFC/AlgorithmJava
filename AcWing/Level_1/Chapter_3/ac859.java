package AcWing.Level_1.Chapter_3;           //AcWing 859. Kruskal算法求最小生成树

import java.io.*;
import java.util.*;

public class ac859 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = 2 * N, INF = 0x3f3f3f3f;
    
    static int n, m;
    static Edge[] edges = new Edge[M];
    static int[] p = new int[N];
    
    static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    
    static int kruskal() {
        //按w升序排列所有区间，Comparator函数 = sign(o1.w-o2.w)，1交换元素位置，0和-1则不变
        Arrays.sort(edges, 0, m, (o1, o2) -> o1.w - o2.w);
        
        int res = 0, cnt = 0;
        for (int i = 0; i < m; i ++) {
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;
            
            if (find(a) != find(b)) {
                res += w;
                cnt ++;
                p[find(a)] = find(b);
            }
        }
        
        return cnt < n - 1? INF: res;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) p[i] = i;  // 初始化并查集
        
        for (int i = 0; i < m; i ++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            edges[i] = new Edge(a, b, c);
        }
        
        int t = kruskal();
        out.println((t == INF? "impossible": t));
        
        out.flush();
    }
    
    static class Edge {
        int a, b, w;
        
        Edge(int aa, int bb, int ww) {
            a = aa; b = bb; w = ww;
        }
    }
}
