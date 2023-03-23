package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac875 {    //875. 快速幂
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static long qmi(long a, long k, long p) {   //Java实现时需扩大为long类型
        long res = 1 % p;
        while (k > 0) {
            if ((k&1) == 1) res = res*a % p;
            k >>= 1;
            a = a*a % p;
        }
        
        return res;
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int p = (int)ins.nval;
            out.println(qmi(a, b, p));
        }

        out.flush();
    }
}
