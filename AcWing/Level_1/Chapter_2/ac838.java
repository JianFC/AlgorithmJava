package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac838 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, m;
    static int cnt;
    static int[] h = new int[N];
    
    static void down(int u) {
        int t = u;
        if (2*u <= cnt && h[2*u]<h[t]) t = 2*u;
        if (2*u+1 <= cnt && h[2*u+1]<h[t]) t = 2*u+1;
        if (t != u) {
            int tp = h[u]; h[u] = h[t]; h[t] = tp;
            down(t);
        }
    }
    
    static void up(int u) {
        while (u/2 > 0 && h[u/2] > h[u]) {
            int tp = h[u]; h[u] = h[u/2]; h[u/2] = tp;
            u >>= 1;
        }
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i=1; i<=n; i++) { ins.nextToken(); h[i] = (int)ins.nval; }
        cnt = n;
        
        for (int i=n/2; i>0; i--) down(i);  //O(n)方式建堆
        
        while (m-- > 0) {
            out.print(h[1]+" ");
            h[1] = h[cnt--];
            down(1);
        }

        out.flush();
    }
}
