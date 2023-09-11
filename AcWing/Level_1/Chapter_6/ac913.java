package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac913 {    //913. 排队打水
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[] t = new int[N];
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) { ins.nextToken(); t[i] = (int)ins.nval; }
        
        Arrays.sort(t, 0, n);   //将t[i]从小到大排序
        
        long res = 0;
        for (int i = 0; i < n; i ++) res += t[i] * (n - i - 1);
        
        out.println(res);
        
        out.flush();
    }
}
