package AcWing.Level_1.Chapter_1;          //AcWing 799. 最长连续不重复子序列

import java.io.*;

public class ac799 { 
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[] a = new int[N], s = new int[N];
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) { ins.nextToken(); a[i] = (int)ins.nval; }
        
        int res = 0;
        for (int i = 0, j = 0; i < n; i ++) {
            s[a[i]] ++;
            
            while (j < i && s[a[i]] > 1) {
                s[a[j]] --;
                j ++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        out.print(res);

        out.flush();
    }
}
