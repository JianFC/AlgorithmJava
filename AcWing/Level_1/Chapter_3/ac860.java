package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac860 {    //AcWing 860. 染色法判定二分图 
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = 2 * N;
    
    static int n, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int[] color = new int[N];
    
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx ++;
    }
    
    static boolean dfs(int u, int c) {
        color[u] = c;
        
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {    // 此处括号不能省略！
                if (!dfs(j, 3 - c)) return false;
            }
            else if (color[j] == c) return false;
        }
        
        return true;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        while (m -- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            add(a, b); add(b, a);
        }
        
        int flag = 1;
        for (int i = 1; i <= n; i ++)
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = 0;
                    break;
                }
            }
        
        out.println((flag == 1? "Yes": "No"));

        out.flush();
    }
}
