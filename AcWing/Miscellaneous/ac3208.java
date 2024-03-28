package AcWing.Miscellaneous;       //3208. Z字形扫描

import java.io.*;
import java.util.*;

class Main {        //矩形思维题 + 矩形扩充 + 条件检查 + 时间复杂度O(n ^ 2)
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 520;
    
    static int n;
    static int[][] a = new int[N][N];
    
    public static void main(String args[]) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j ++) {
                ins.nextToken(); a[i][j] = (int)ins.nval;   //从(1, 1)开始输入
            }
        
        for (int sum = 2; sum <= n * 2; sum ++) {    //枚举斜着的每一行的横纵坐标之和，对原矩阵进行扩展
            if (sum % 2 != 0) {                     //由图可知该行为偶数行
                for (int i = 1; i < sum; i ++)      //枚举扩充后的矩阵的斜着的每一行的横坐标，从上往下输出
                    if (i >= 1 && i <= n && sum - i >= 1 && sum - i <= n)     //(i, sum - i)坐标位于原矩形内
                        out.print(a[i][sum - i] + " ");     //输出偶数行
            }
            else {              //该行为奇数行
                for (int i = sum - 1; i >= 1; i --)     //从下往上输出
                    if (i >= 1 && i <= n && sum - i >= 1 && sum - i <= n)       //check是否在原矩形内
                        out.print(a[i][sum - i] + " ");
            }
        }  
        
        
        out.flush();
    }
}