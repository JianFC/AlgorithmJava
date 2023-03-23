package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac878 {    //878. 线性同余方程
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int exgcd(int a, int b, int[] x, int[] y) {
        if (b == 0) {
            x[0] = 1; y[0] = 0;
            return a;
        }
        
        int d = exgcd(b, a % b, y, x);
        y[0] -= a/b*x[0];
        return d;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int m = (int)ins.nval;
            
            int[] x = {0}, y = {0};
            int d = exgcd(a, m, x, y);
            
            if (b % d == 0) out.println((long)x[0]*(b/d) % m);  //注意数据范围，乘法可能越界
            else out.println("impossible");
        }

        out.flush();
    }
}
