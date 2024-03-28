package AcWing.Level_1.Chapter_4;    //892. 台阶-Nim游戏

import java.io.*;

public class ac892 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            if ((i & 1) == 1) res ^= a;     //二进制优化
        }
        
        if (res != 0) out.println("Yes");
        else out.println("No");

        out.flush();
    }
}
