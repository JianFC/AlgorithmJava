package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac2816 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, m;
    static int[] a = new int[N], b = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i = 0; i < n; i++) { ins.nextToken(); a[i] = (int)ins.nval; }
        for (int i = 0; i < m; i++) { ins.nextToken(); b[i] = (int)ins.nval; }
        
        int j = 0;
        for (int i = 0; i < m; i++) 
            if (j < n && a[j] == b[i]) j++;
        
        if (j == n) out.print("Yes");
        else out.print("No");

        out.flush();
    }
}
