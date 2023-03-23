package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac847 {    //847. 图中点的层次
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = N;
    
    static int n, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int[] d = new int[N];
    static int hh, tt = -1;
    static int[] q = new int[N];
    
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
    
    static int bfs() {
        Arrays.fill(d, -1);
        
        d[1] = 0;
        q[++tt] = 1;
        
        while (hh <= tt) {
            int t = q[hh++];
            
            for (int i=h[t]; i!=-1; i=ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t]+1;
                    q[++tt] = j;
                }
            }
        }
        
        return d[n];
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        for (int i=0; i<m; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            add(a, b);
        }
        
        out.println(bfs());

        out.flush();
    }
}
