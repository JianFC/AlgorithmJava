package AcWing.Level_1.Chapter_1;       //AcWing 800. 数组元素的目标和

import java.io.*;

public class ac800 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, m, x;
    static int[] a = new int[N], b = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        ins.nextToken(); x = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) { ins.nextToken(); a[i] = (int)ins.nval; }
        for (int i = 0; i < m; i ++) { ins.nextToken(); b[i] = (int)ins.nval; }
        
        for (int i = 0, j = m - 1; i < n; i ++) {
            while (j > 0 && a[i] + b[j] > x) j --;
            if (j > 0 && a[i] + b[j] == x) out.print(i + " " + j);
        }

        out.flush();
    }
}
