package AcWing.Level_1.Chapter_4;

import java.io.*;
import java.util.*;

public class ac893 {    //893. 集合-Nim游戏
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110, M = 10010;
    
    static int n, m;
    static int[] s = new int[N], f = new int[M];    //s存储S数组，f记忆化搜索

    static int sg(int x) {
        if (f[x] != -1) return f[x];
        
        Set<Integer> S = new HashSet<Integer>();
        
        for (int i=0; i<m; i++) {
            int ss = s[i];
            if (x >= ss) S.add(sg(x-ss));    //dfs求子节点SG集合
        }
        
        //求SG(x)
        for (int i=0; ; i++) {
            if (!S.contains(i))
                return f[x] = i;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Arrays.fill(f, -1);
        
        ins.nextToken(); m = (int)ins.nval;
        for (int i=0; i<m; i++) { ins.nextToken(); s[i] = (int)ins.nval; }
        
        ins.nextToken(); n = (int)ins.nval;
        int res = 0;
        while (n-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            res ^= sg(a);
        }
        
        if (res != 0) out.println("Yes");
        else out.println("No");

        out.flush();
    }
}
