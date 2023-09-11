package AcWing.Level_1.Chapter_4;

import java.io.*;
import java.util.*;

public class ac888 {    //888. 求组合数 IV
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 5010;
    
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] st = new boolean[N];
    static int[] sum = new int[N];
    
    //线性筛
    static void get_primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;
            
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                
                if (i % primes[j] == 0) break;
            }
        }
    }
    
    //计算n!中质因子p的幂次
    static int get(int n, int p) {
        int res = 0;
        while (n > 0) {
            res += n / p;
            n /= p;
        }
        
        return res;
    }
    
    //高精度乘法
    static List<Integer> mul(List<Integer> A, int b) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0, t = 0; i < A.size() || t != 0; i++) {
            if (i < A.size()) t += A.get(i) * b;
            res.add(t % 10);
            t /= 10;
        }
        
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        
        return res;
    }
       
    public static void main(String[] args) throws Exception {
        ins.nextToken(); int a = (int)ins.nval;
        ins.nextToken(); int b = (int)ins.nval;
        
        get_primes(a);
        
        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            sum[i] = get(a, p) - get(a - b, p) - get(b, p);
        }
        
        List<Integer> ans = new ArrayList<>(); ans.add(1);
        
        for (int i = 0; i < cnt; i++)
            for (int j = 0; j < sum[i]; j++)    
                ans = mul(ans, primes[i]);
        
        for (int i = ans.size() - 1; i >= 0; i--) out.print(ans.get(i));
        
        out.flush();
    }
}
