package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac797 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, m;
    static int[] a = new int[N], b = new int[N];
    
    static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) { ins.nextToken(); a[i] = (int)ins.nval; }
        
        for (int i = 1; i <= n; i ++) insert(i, i, a[i]);
        
        while (m-- > 0) {
            ins.nextToken(); int l = (int)ins.nval;
            ins.nextToken(); int r = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            insert(l, r, c);
        }
        
        for (int i = 1; i <= n; i ++) { b[i] += b[i - 1]; out.print(b[i] + " "); }

        out.flush();
    }
}
