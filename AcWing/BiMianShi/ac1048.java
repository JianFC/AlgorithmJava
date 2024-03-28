package AcWing.BiMianShi;       //AcWing 1048. 鸡蛋的硬度

import java.io.*;
import java.util.*;

class Main {    //DP + 思维记忆题 + 做法1 + 时O(n ^ 2) * m)
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110, M = 12;
    
    static int n, m;
    static int[][] f = new int[N][M];   //f[i][j]表示所有测量区间长度为i，且有j个鸡蛋可用的测量方案的最坏情况的最小值
    
    public static void main(String[] args) throws Exception {
        while (in.hasNext() && (n = in.nextInt()) != 0 && (m = in.nextInt()) != 0) {
            for (int i = 1; i <= n; i ++) f[i][1] = i;      //初始化边界，只有一个鸡蛋，最坏情况为i
            for (int i = 1; i <= m; i ++) f[1][i] = 1;      //区间长度为1，初始化为1
            
            for (int i = 2; i <= n; i ++)   //枚举区间长度，从2开始
                for (int j = 2; j <= m; j ++) {
                    f[i][j] = f[i][j - 1];
                    for (int k = 1; k <= i; k ++)
                        f[i][j] = Math.min(f[i][j], Math.max(f[k - 1][j - 1], f[i - k][j]) + 1);    //状态转移方程
                }
                
            out.println(f[n][m]);       //最终答案
        }
        
        out.flush();
    }
}