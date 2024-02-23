package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac897 {    //897. 最长公共子序列
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010;
    
    static int n, m;
    static char[] a = new char[N], b = new char[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws Exception {
        String[] ss = inb.readLine().split(" +");
        n = Integer.parseInt(ss[0]); m = Integer.parseInt(ss[1]);
        
        String tmp = inb.readLine(); tmp = " " + tmp; a = tmp.toCharArray();
        tmp = inb.readLine(); tmp = " " + tmp; b = tmp.toCharArray();

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a[i] == b[j]) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
            
        out.println(f[n][m]);

        out.flush();
    }
}
