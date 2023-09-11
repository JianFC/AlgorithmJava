package AcWing.Level_1.Chapter_5;

import java.io.*;
import java.util.*;

public class ac898 {    //898. 数字三角形（降维优化）
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 510, INF = 0x3f3f3f3f;
    
    static int n;
    static int[][] a = new int[N][N];
    static int[] f = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        //初始化f[j]
        Arrays.fill(f, -INF);
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++) { ins.nextToken(); a[i][j] = (int)ins.nval; }
        
        f[1] = 0;     //初始化f[1]
        for (int i = 1; i <= n; i++)
            for (int j = i; j >= 1; j--)
                f[j] = Math.max(f[j], f[j - 1]) + a[i][j];
        
        //找出底层最大的路径
        int k = 1;
        for (int i = 1; i <= n; i++) {
            if (f[i] > f[k]) k = i;
        }
        
        out.println(f[k]);
        
        out.flush();
    }
}
