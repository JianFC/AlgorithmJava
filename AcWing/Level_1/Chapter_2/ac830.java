package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac830 {    //830. 单调栈
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int tt;
    static int[] stk = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            
            while (tt > 0 && stk[tt] >= x) tt--;
            if (tt > 0) out.print(stk[tt]+" ");
            else out.print("-1 ");
            
            stk[++tt] = x;
        }

        out.flush();
    }
}
