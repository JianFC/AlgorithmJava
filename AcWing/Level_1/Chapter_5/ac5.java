package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac5 {  //5. 多重背包问题 II_位进制优化
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1000*15, M = 2010;
    
    static int n, m;
    static int[] v = new int[N], w = new int[N];
    static int cnt;
    static int[] f = new int[M];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int vv = (int)ins.nval;
            ins.nextToken(); int ww = (int)ins.nval;
            ins.nextToken(); int s = (int)ins.nval;
            
            int k = 1;
            while (k <= s) {
                cnt++;
                v[cnt] = k*vv;
                w[cnt] = k*ww;
                s -= k; k *= 2; //注意顺序
            }
            
            if (s > 0) {
                cnt++;
                v[cnt] = s*vv;
                w[cnt] = s*ww;
            }
        }
        
        for (int i=1; i<=cnt; i++)
            for (int j=m; j>=v[i]; j--)
                f[j] = Math.max(f[j], f[j-v[i]]+w[i]);
                
        out.println(f[m]);

        out.flush();
    }
}
