package AcWing.BiMianShi;

import java.io.*;
import java.util.*;

class Main {    //第二种DP方式 + 思维题记忆 + 时O(nm)
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110, M = 12;
    
    static int n, m;
    static int[][] f = new int[N][M];   //f[i][j]表示有j个鸡蛋，测量i次的所有测量方案的能测的区间长度的最大值

    public static void main(String[] args) throws Exception {
        while (in.hasNext() && (n = in.nextInt()) != 0 && (m = in.nextInt()) != 0) {
            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j <= m; j ++) 
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j] + 1;
                
                if (f[i][m] >= n) {     //找到最小的i
                    out.println(i);
                    break;
                }
            }
        }
        
        out.flush();
    }    
}
