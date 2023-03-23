package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac887 {    //887. 求组合数 III
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static long qmi(long a, long k, long p) {
        long res = 1 % p;
        while (k > 0) {
            if ((k&1) == 1) res = res*a % p;
            k >>= 1;
            a = a*a % p;
        }
        
        return res;
    }
    
    static long C(long a, long b, long p) {
        if (b > a) return 0;
        
        long res = 1;
        for (long i=1, j=a; i<=b; i++, j--) {
            res = res*j % p;
            res = res*qmi(i, p-2, p) % p;
        }
        
        return res;
    }
    
    static long lucas(long a, long b, long p) {
        if (a<p && b<p) return C(a, b, p);
        else return C(a % p, b % p, p)*lucas(a/p, b/p, p) % p;
    }
    
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(inb.readLine());
        
        while (n-- > 0) {
            //备注: StreamTokenizer读取大于10^16的整数时会发生精度丢失
            String[] tmp = inb.readLine().split("\\s+");
            // \\s表示空格,回车,换行等空白符, +号表示一个或多个的意思
            long a = Long.parseLong(tmp[0]);
            long b = Long.parseLong(tmp[1]);
            long p = Long.parseLong(tmp[2]);
            out.println(lucas(a, b, p));
        }

        out.flush();
    }
}
