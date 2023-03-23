package AcWing.Level_1.Chapter_3;

import java.io.*;
import java.util.*;

public class ac861 {    //861. 二分图的最大匹配
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 510, M = 100010;
    
    static int n1, n2, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];
    
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
    
    static boolean find(int x) {
        for (int i=h[x]; i!=-1; i=ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        
        return false;
    }
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n1 = (int)ins.nval;
        ins.nextToken(); n2 = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        while (m-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            add(a, b);
        }
        
        int res = 0;
        for (int i=1; i<=n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) res++;
        }
        
        out.println(res);

        out.flush();
    }
}
