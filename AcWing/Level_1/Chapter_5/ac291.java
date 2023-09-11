package AcWing.Level_1.Chapter_5;

import java.io.*;
import java.util.*;

public class ac291 {    //291. 蒙德里安的梦想
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 13, M = 1 << N;
    
    static int n, m;
    static long[][] f = new long[N][M]; //f[i, j]代表i-1列延伸至i列的行的状态j
    static boolean[] st = new boolean[M];   //st[i]代表状态i是否具有连续偶数个0

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
    
        while (n != 0 || m != 0) {
            //f数组清零
            for (int i = 0; i < N; i++) Arrays.fill(f[i], 0);
            
            //预处理st[]，大循环内进行
            for (int i = 0; i < 1 << n; i++) {    //枚举状态
                st[i] = true;
                
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) {  //当前行是1
                        if ((cnt & 1) == 1) { st[i] = false; break;}  //前有奇数个0, false
                        cnt = 0;    //偶数个0, 重置
                    }
                    else cnt++;
                }
                
                if ((cnt & 1) == 1) st[i] = false;  //奇数个1
            }
        
            f[0][0] = 1;    //初始化
            
            //DP过程
            for (int i = 1; i <= m; i++)    //枚举列，注意多枚举一列，答案为f[m][0]
                for (int j = 0; j < 1 << n; j++)  //枚举状态
                    for (int k = 0; k < 1 << n; k++)  //枚举上一列状态
                        if ((j & k) == 0 && st[j | k])
                            f[i][j] += f[i - 1][k];
            
            out.println(f[m][0]);   //答案为f[m][0]
            
            ins.nextToken(); n = (int)ins.nval;
            ins.nextToken(); m = (int)ins.nval;
        }

        out.flush();
    }
}
