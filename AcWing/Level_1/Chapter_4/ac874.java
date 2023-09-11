package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac874 {    //874. 筛法求欧拉函数
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1000010;
    
    static int n;
    static int[] phi = new int[N];  //phi[i]表示i的欧拉函数值
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] st = new boolean[N];
    
    static long getEulers(int n) {
        phi[1] = 1;     //注意边界
        
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                phi[i] = i - 1;   //当i时质数时，有定义知1~i-1与i互质，故phi[i] = i-1;
            }
            
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                
                if (i % primes[j] == 0) {
                    phi[primes[j] * i] = primes[j] * phi[i];
                    break;
                }
                
                phi[primes[j] * i] = phi[i] * (primes[j] - 1);
            }
        }
        
        long res = 0;
        for (int i = 1; i <= n; i++) res += phi[i];
        return res;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        out.println(getEulers(n));

        out.flush();
    }
}
