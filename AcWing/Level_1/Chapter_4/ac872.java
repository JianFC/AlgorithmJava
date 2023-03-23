package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac872 {    //872. 最大公约数
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int gcd(int a, int b) {
        return b!=0? gcd(b, a % b): a;
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            
            out.println(gcd(a, b));
        }

        out.flush();
    }
}
