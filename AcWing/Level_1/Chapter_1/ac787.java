package AcWing.Level_1.Chapter_1;       //AcWing 787. 归并排序       

import java.io.*;

public class ac787 { 
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[] q = new int[N], tmp = new int[N];
    
    static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;
        
        int mid = l + r >> 1, i = l, j = mid + 1, k = 0;
        mergeSort(q, l, mid); mergeSort(q, mid + 1, r);
        
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) tmp[k ++] = q[i ++];
            else tmp[k ++] = q[j ++];
        }
        
        while (i <= mid) tmp[k ++] = q[i ++];
        while (j <= r) tmp[k ++] = q[j ++];
        
        for (i = l, j = 0; i <= r; i ++, j ++) q[i] = tmp[j];
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) { ins.nextToken(); q[i] = (int)ins.nval; }
        
        mergeSort(q, 0, n - 1);
        
        for (int i = 0; i < n; i ++) out.print(q[i] + " ");
        
        out.flush();
    } 
}
