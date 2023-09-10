package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac846 {    //846. 树的重心
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = 2 * N; //注意无向图
    
    static int n;
    static int idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static boolean[] st = new boolean[N];
    static int ans = N;
    
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
    
    static int dfs(int u) { //返回以u为根的子树的结点个数，包括u
        st[u] = true;
        
        int res = 0, sum = 1;   //res存储若删去当前点，剩下的连通块点数最大值
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                int s = dfs(j);
                sum += s;
                res = Math.max(res, s);
            } 
        }
        
        res = Math.max(res, n - sum);
        ans = Math.min(res, ans);
        
        return sum;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        for (int i = 0; i < n-1; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            add(a, b); add(b, a);
        }
        
        dfs(1);
        
        out.println(ans);

        out.flush();
    }
}
