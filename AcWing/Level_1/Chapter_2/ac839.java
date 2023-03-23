package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac839 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int cnt;
    static int[] h = new int[N], ph = new int[N], hp = new int[N];
    
    static void swap(int[] a, int x, int y) {
        int tp = a[x]; a[x] = a[y]; a[y] = tp;
    }
    
    static void heap_swap(int a, int b) {
        // swap(ph, hp[a], hp[b]);     //注意函数参数是下标！
        // swap(hp, a, b);
        // swap(h, a, b);
        int tp = ph[hp[a]]; ph[hp[a]] = ph[hp[b]]; ph[hp[b]] = tp;
        tp = hp[a]; hp[a] = hp[b]; hp[b] = tp;
        tp = h[a]; h[a] = h[b]; h[b] = tp;
    }
    
    static void down(int u) {
        int t = u;
        if (2*u <= cnt && h[2*u] < h[t]) t = 2*u;
        if (2*u+1 <= cnt && h[2*u+1] < h[t]) t = 2*u+1;
        if (t != u) {
            heap_swap(t, u);
            down(t);
        }
    }
    
    static void up(int u) {
        while (u/2 > 0 && h[u/2] > h[u]) {
            heap_swap(u/2, u);
            u >>= 1;
        }
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        int kk = 0;
        while (n-- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            
            if (op.equals("I")) {
                ins.nextToken(); int x = (int)ins.nval;
                cnt++; kk++;
                ph[kk] = cnt; hp[cnt] = kk;
                h[cnt] = x; up(cnt);
            }
            else if (op.equals("PM")) out.println(h[1]);
            else if (op.equals("DM")) {
                heap_swap(1, cnt--); down(1); 
            }
            else if (op.equals("D")) {
                ins.nextToken(); int k = (int)ins.nval;
                k = ph[k];
                heap_swap(k, cnt--); down(k); up(k);
            }
            else {
                ins.nextToken(); int k = (int)ins.nval;
                ins.nextToken(); int x = (int)ins.nval;
                k = ph[k];
                h[k] = x; down(k); up(k);
            }
        }

        out.flush();
    }
}
