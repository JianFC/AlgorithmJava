package AcWing.Level_1.Chapter_5;

import java.io.*;
import java.util.*;

public class ac285 {    //AcWing 285. 没有上司的舞会
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 6010, M = N;
    
    static int n;
    static int[] happy = new int[N];
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int idx;
    static boolean[] has_fa = new boolean[N];
    static int[][] f = new int[N][2];
    
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
    
    //树形DP
    static void dfs(int u) {
        f[u][1] = happy[u];     //如果选择该结点,则加上其happy值
        
        //对其儿子dp
        for (int i=h[u]; i!=-1; i = ne[i]) {
            int j = e[i];   //其儿子
            dfs(j);     //递归搜索其儿子
            
            //递归结束，回溯，更新dp数组
            f[u][0] += Math.max(f[j][0], f[j][1]);
            f[u][1] += f[j][0];
        }
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        Arrays.fill(h, -1);     //初始化邻接表头数组
        
        for (int i=1; i<=n; i++) { ins.nextToken(); happy[i] = (int)ins.nval; }
        
        for (int i=0; i<n-1; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            add(b, a);  //b是a的直接上司
            has_fa[a] = true;
        }
        
        int root = 1;
        while (has_fa[root]) root++;    //寻找树根
        
        dfs(root);  //从根结点开始向下dp
        
        out.println(Math.max(f[root][0], f[root][1]));
        
        out.flush();
    }
}
