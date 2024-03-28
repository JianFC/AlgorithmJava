package AcWing.Level_1.Chapter_4;    //894. 拆分-Nim游戏

import java.io.*;
import java.util.*;

public class ac894 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 110;
    
    static int[] f = new int[N];    //记忆化搜索
    
    static int sg(int x) {
        if (f[x] != -1) return f[x];
        
        Set<Integer> S = new HashSet<Integer>();
        for (int i = 0; i < x; i++)
            for (int j = 0; j <= i; j++)
                S.add(sg(i) ^ sg(j));
        
        //求SG
        for (int i = 0; ; i++)
            if (!S.contains(i))
                return f[x] = i;
    }

    public static void main(String[] args) throws Exception {
        Arrays.fill(f, -1);
        
        ins.nextToken(); int n = (int)ins.nval;
        
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
