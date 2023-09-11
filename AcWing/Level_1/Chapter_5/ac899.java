package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac899 {    //899 编辑距离
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010, M = 15;
    
    static int n, m;
    static char[][] str = new char[N][M];
    static int[][] f = new int[N][N];
    
    static int edit_dist(char[] a, char[] b) {
        int la = a.length - 1, lb = b.length - 1;   //注意la, lb取值
        
        for (int i = 1; i <= la; i++) f[i][0] = i;
        for (int i = 1; i <= lb; i++) f[0][i] = i;
        
        for (int i = 1; i <= la; i++)
            for (int j = 1; j <= lb; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + (a[i] == b[j]? 0: 1));
            }
            
        return f[la][lb];
    }
    
    public static void main(String[] args) throws Exception{
        String[] s = inb.readLine().split(" +");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        
        //注意下标从1开始
        for (int i = 0; i < n; i++) str[i] = (" " + inb.readLine()).toCharArray();
        
        while (m-- > 0) {
            s = inb.readLine().split(" +");
            char[] ss = (" " + s[0]).toCharArray(); int limit = Integer.parseInt(s[1]);
            
            int res = 0;
            for (int i = 0; i < n; i++)
                if (edit_dist(str[i], ss) <= limit) res++;
            
            out.println(res);
        }
        
        out.flush();
    }
}
