package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac204 {    //204. 表达整数的奇怪方式
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static long exgcd(long a, long b, long[] x, long[] y) {
        if (b == 0) {
            x[0] = 1; y[0] = 0;
            return a;
        }
        
        long d = exgcd(b, a % b, y, x);
        y[0] -= a/b*x[0];
        return d;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        boolean flag = true;
        ins.nextToken(); long a1 = (long)ins.nval;
        ins.nextToken(); long m1 = (long)ins.nval;
        
        while (n-- > 1) {
            ins.nextToken(); long a2 = (long)ins.nval;
            ins.nextToken(); long m2 = (long)ins.nval;
            
            long[] x = {0}, y = {0};
            long d = exgcd(a1, a2, x, y);
            if ((m2-m1) % d != 0) {
                flag = false; break;
            }
            
            long k1 = x[0]*(m2-m1)/d;
            long t = a2/d;
            k1 = (k1 % t+t) % t;    //正数范围内最小化k1
            
            //更新m1, a1
            m1 = a1*k1+m1;
            a1 = Math.abs(a1*t);    //abs保证最终x为正数
        }
        
        if (flag) out.println((m1%a1+a1)%a1);
        else out.println(-1);

        out.flush();
    }
}
