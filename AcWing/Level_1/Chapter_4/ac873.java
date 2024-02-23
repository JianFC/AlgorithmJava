package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac873 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    // 返回欧拉函数值
    static int phi(int x) {
        int res = x;
        
        for (int i = 2; i <= x / i; i ++) {
            if (x % i == 0) {
                res = res / i * (i - 1);  //整数不支持小数除法，将res*(1-1/i)变换为res/i*(i-1)
                while (x % i == 0) x /= i;  
            }
        }
        
        if (x > 1) res = res / x * (x - 1);
        
        return res;
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n -- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            out.println(phi(x));
        }

        out.flush();
    }
}
