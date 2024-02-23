package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac877 {    //877. 扩展欧几里得算法
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int exgcd(int a, int b, int[] x, int[] y) {  //数组模拟C++中引用
        if (b == 0) {
            x[0] = 1; y[0] = 0;
            return a;
        }
        
        int d = exgcd(b, a % b, y, x);
        y[0] -= a / b * x[0];
        return d;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n -- > 0) {
            ins.nextToken(); int a = (int)ins.nval;    
            ins.nextToken(); int b = (int)ins.nval;
            
            int[] x = {0}, y = {0};
            exgcd(a, b, x, y);
            out.println(x[0] + " " + y[0]);
        }

        out.flush();
    }
}
