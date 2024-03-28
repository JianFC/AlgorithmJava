package AcWing.Level_1.Chapter_4;       //AcWing 868. 筛质数

import java.io.*;

public class ac868_2 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1000010;
    
    static int n;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] st = new boolean[N];
    
    // 埃式筛法，时间复杂度O(nloglogn)
    static void getPrimes(int n) {
        for (int i = 2; i <= n; i ++) {
            if (!st[i]) {
                primes[cnt ++] = i;
                
                for (int j = i + i; j <= n; j += i) st[j] = true;
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
