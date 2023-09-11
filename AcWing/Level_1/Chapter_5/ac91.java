package AcWing.Level_1.Chapter_5;

import java.io.*;
import java.util.*;

public class ac91 {     //91. 最短Hamilton路径
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 21, M = 1 << N, INF = 0x3f3f3f3f;
    
    static int n;
    static int[][] f = new int[M][N];   //f[i][j]代表从0-j个点的路径状态i的最小值
    static int[][] w = new int[N][N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) { ins.nextToken(); w[i][j] = (int)ins.nval; }
            
        for (int i = 0; i < M; i++) Arrays.fill(f[i], INF);     //初始化
        f[1][0] = 0;
        
        for (int i = 0; i < 1 << n; i++)  //枚举状态i
            for (int j = 0; j < n; j++)
                if ((i >> j & 1) == 1)    //走过j点
                    for (int k = 0; k < n; k++) //枚举j前一个走过的点k
                        if (((i - (1 << j)) >> k & 1) == 1)     //注意运算符优先级
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
        
        out.println(f[(1 << n) - 1][n - 1]);

        out.flush();
    }
}
