package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac831 {    //831. KMP字符串
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = 1000010;
    
    static int n, m;
    static int[] ne = new int[N];
    static char[] p = new char[N], s = new char[M];

    
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(inb.readLine());   //下标从1开始
        String tmp = inb.readLine(); tmp = " " + tmp; p = tmp.toCharArray();
        m = Integer.parseInt(inb.readLine());
        tmp = inb.readLine(); tmp = " " + tmp; s = tmp.toCharArray();
        
        for (int i = 2, j = 0; i <= n; i ++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j ++;
            ne[i] = j;
        }
        
        for (int i = 1, j = 0; i <= m; i ++) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j ++;
            if (j == n) {
                out.print(i - n + " ");
                j = ne[j];
            }
        }

        out.flush();
    }
}
