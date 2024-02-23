package AcWing.Level_1.Chapter_3;

import java.io.*;

public class ac842 {    //842. 排列数字
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 10;
    
    static int n;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];
    
    static void dfs(int u) {
        if (u == n) {   //退出条件
            for (int i = 0; i < n; i ++) out.print(path[i]+" ");
            out.println();
            return;
        }
        
        for (int i = 1; i <= n; i ++) 
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;  //恢复现场
            }
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        dfs(0);

        out.flush();
    }
}
