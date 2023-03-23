package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac104 {    //104. 货仓选址
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[] a = new int[N];
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i=0; i<n; i++) { ins.nextToken(); a[i] = (int)ins.nval; }
        
        Arrays.sort(a, 0, n);   //从小到大排序，用于求中位数
        
        long res = 0;
        for (int i=0; i<n; i++) res += Math.abs(a[i]-a[(n-1)/2]);
        
        out.println(res);
        
        out.flush();
    }
}
