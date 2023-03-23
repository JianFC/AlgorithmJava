package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac866 {    //866. 试除法判定质数
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static boolean isPrime(int x) {
        if (x < 2) return false;
        else
            for (int i=2; i<=x/i; i++)
                if (x % i == 0) return false;
        
        return true;
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            out.println((isPrime(a)? "Yes": "No"));
        }

        out.flush();
    }
}
