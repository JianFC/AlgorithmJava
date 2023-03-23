package AcWing.Level_1.Chapter_5;

import java.io.*;
import java.util.*;

public class ac901 {    //AcWing 901. 滑雪
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 310;
    
    static int n, m;
    static int[][] h = new int[N][N];
    static int[][] f = new int[N][N];   //记忆化搜索
    
    static int dp(int x, int y) {
        if (f[x][y] != -1) return f[x][y];
        
        f[x][y] = 1;    //初始化f[x][y]
        
        int[] dx= {-1, 0, 1, 0}, dy = {0, 1, 0, -1};    //四个移动方向
        for (int i=0; i<4; i++) {
            int xx = x+dx[i], yy = y+dy[i];
            if (xx>=1 && xx<=n && yy>=1 && yy<=m && h[xx][yy]<h[x][y])
                f[x][y] = Math.max(f[x][y], dp(xx, yy)+1);
        }
        
        return f[x][y];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i=0; i<=n; i++) Arrays.fill(f[i], -1);
        
        for (int i=1; i<=n; i++)
            for (int j=1; j<=m; j++) { ins.nextToken(); h[i][j] = (int)ins.nval; }
            
        int res = 0;
        for (int i=1; i<=n; i++)
            for (int j=1; j<=m; j++)
                res = Math.max(res, dp(i, j));
        
        out.println(res);

        out.flush();
    }
}
