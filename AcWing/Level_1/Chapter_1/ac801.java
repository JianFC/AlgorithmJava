package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac801 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int n;
    
    static int lowbit(int x) {
        return x & -x;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            
            int res = 0;
            while (x > 0) { x -= lowbit(x); res++; }
            out.print(res + " ");
        }

        out.flush();
    }
}
