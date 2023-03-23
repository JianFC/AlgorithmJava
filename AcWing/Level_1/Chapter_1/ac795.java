package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac795 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, m;
    static int[] a = new int[N], s = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i=1; i<=n; i++) { ins.nextToken(); a[i] = (int)ins.nval; }
        
        for (int i=1; i<=n; i++) s[i] = s[i-1]+a[i];
        
        while (m-- > 0) {
            ins.nextToken(); int l = (int)ins.nval;
            ins.nextToken(); int r = (int)ins.nval;
            out.println(s[r]-s[l-1]);
        }

        out.flush();
    }
}
