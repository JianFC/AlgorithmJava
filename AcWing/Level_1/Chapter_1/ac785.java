package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac785 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[] q = new int[N];
    
    static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        
        int x = q[l+r>>1], i = l-1, j = r+1;
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int t = q[i]; q[i] = q[j]; q[j] = t;
            }
        }
        
        quickSort(q, l, j); quickSort(q, j+1, r); 
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i=0; i<n; i++) { ins.nextToken(); q[i] = (int)ins.nval; }
        
        quickSort(q, 0, n-1);
        
        for (int i=0; i<n; i++) out.print(q[i]+" ");
        
        out.flush();
    }
}
