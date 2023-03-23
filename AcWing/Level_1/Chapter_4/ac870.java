package AcWing.Level_1.Chapter_4;

import java.io.*;
import java.util.*;

public class ac870 {    //870. 约数个数
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int mod = (int)1e9+7;
    
    static Map<Integer, Integer> primes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            
            for (int i=2; i<=x/i; i++)
                if (x % i == 0)
                    while (x % i == 0) {
                        primes.put(i, primes.getOrDefault(i, 0)+1);
                        x /= i;
                    }
            
            if (x > 1) primes.put(x, primes.getOrDefault(x, 0)+1);
        }
        
        long res = 1;   //注意数据范围
        for (int v: primes.values()) 
            res = res*(v+1) % mod;
        
        out.println(res);
        
        out.flush();
    }
}
    