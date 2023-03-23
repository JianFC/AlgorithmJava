package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac867 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static void divide(int x) {
        for (int i=2; i<=x/i; i++)
            if (x % i == 0) {
                int s = 0;
                while (x % i == 0) {
                    x /= i; s++;
                }
                out.println(i+" "+s);
            }
        
        if (x > 1) out.println(x+" 1");
        out.println();
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            divide(a);
        }

        out.flush();
    }
}
