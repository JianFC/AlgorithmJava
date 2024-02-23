package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac886 {    //886. 求组合数 II
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, mod = (int)1e9 + 7;
    
    static long[] fact = new long[N], infact = new long[N];
    
    static long qmi(long a, long k, long p) {
        long res = 1 % p;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        
        return res;
    }
    
    public static void main(String[] args) throws Exception {
        //预处理阶乘
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i ++) {
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = infact[i - 1] * qmi(i, mod - 2, mod) % mod;
        }
        
        ins.nextToken(); int n = (int)ins.nval; 
        while (n -- > 0) {
            ins.nextToken(); int a = (int)ins.nval;     
            ins.nextToken(); int b = (int)ins.nval; 
            out.println(fact[a] * infact[a - b] % mod * infact[b] % mod);
        }
        
        out.flush();
    }
}
