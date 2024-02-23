package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac282 {    //AcWing 282. 石子合并
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 310, INF = 0x3f3f3f3f;
    
    static int n;
    static int[] s = new int[N];
    static int[][] f = new int[N][N];
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) { ins.nextToken(); s[i] = (int)ins.nval; }
        for (int i = 1; i <= n; i ++) s[i] += s[i - 1];    //处理前缀和
        
        for (int len = 2; len <= n; len ++) {    //枚举区间长度
            for (int i = 1; i + len - 1 <= n; i ++) {    //枚举左端点
                int l = i, r = i + len - 1;     //区间左右端点
                f[l][r] = INF;
                
                for (int k = l; k < r; k ++)
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
            }
        }
        
        out.println(f[1][n]);
        
        out.flush();
    }
}
