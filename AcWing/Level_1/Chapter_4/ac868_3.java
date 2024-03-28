package AcWing.Level_1.Chapter_4;       //AcWing 868. 筛质数

import java.io.*;

public class ac868_3 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1000010;
    
    static int n;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] st = new boolean[N];
    
    static void getPrimes(int n) {
        for (int i = 2; i <= n; i ++) {
            if (!st[i]) primes[cnt ++] = i;
            
            for (int j = 0; primes[j] <= n / i; j ++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        getPrimes(n);
        
        out.println(cnt);

        out.flush();
    }
}
