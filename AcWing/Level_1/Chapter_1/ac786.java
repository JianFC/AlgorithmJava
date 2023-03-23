package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac786 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, k;
    static int[] q = new int[N];
    
    static int quickSort(int[] q, int l, int r, int k) {
        if (l >= r) return q[l];
        
        int x = q[l+r>>1], i = l-1, j = r+1;
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int t = q[i]; q[i] = q[j]; q[j] = t;
            }
        }
        
        if (k-(j-l+1) > 0) return quickSort(q, j+1, r, k-(j-l+1));
        else return quickSort(q, l, j, k);
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); k = (int)ins.nval;
        
        for (int i=0; i<n; i++) { ins.nextToken(); q[i] = (int)ins.nval; }
        
        out.print(quickSort(q, 0, n-1, k));
        
        out.flush();
    }
}
