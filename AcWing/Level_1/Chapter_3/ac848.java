package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac848 {    //848. 有向图的拓扑序列
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = N;
    
    static int n, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int hh, tt = -1;
    static int[] q = new int[N];
    static int[] d = new int[N];    //d[i]表示结点i的入度
    
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    } 
    
    static boolean topoSort() {
        for (int i=1; i<=n; i++)
            if (d[i] == 0) q[++tt] = i; //初始将所有入读为0的点加入队列
        
        while (hh <= tt) {
            int t = q[hh++];
            
            for (int i=h[t]; i!=-1; i=ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) q[++tt] = j;
            }
        }
        
        return tt == n-1;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        for (int i=0; i<m; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            add(a, b); d[b]++;
        }
        
        if (topoSort())
            for (int i=0; i<n; i++) out.print(q[i]+" ");
        else out.print("-1");
        
        out.flush();
    }
}
