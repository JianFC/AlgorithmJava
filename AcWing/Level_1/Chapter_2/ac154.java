package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac154 {    //154. 滑动窗口
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1000010;
    
    static int n, k;
    static int[] a = new int[N];
    static int hh, tt = -1;
    static int[] q = new int[N];    //存储下标的单调队列(与目标值一一对应，所以合理)
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); k = (int)ins.nval;
        
        for (int i = 0; i < n; i++) { ins.nextToken(); a[i] = (int)ins.nval; }
        
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            
            if (i - k + 1 >= 0) out.print(a[q[hh]] + " ");
        }
        out.println();
        
        hh = 0; tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            
            while (hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++tt] = i;
            
            if (i - k + 1 >= 0) out.print(a[q[hh]] + " ");
        }

        out.flush();
    }
}
