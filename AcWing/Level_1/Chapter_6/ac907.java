package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac907 {    // 907. 区间覆盖
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static Interval[] ivals = new Interval[N];
    
    public static void main(String[] args) throws Exception {
        int st, ed;
        ins.nextToken(); st = (int)ins.nval;
        ins.nextToken(); ed = (int)ins.nval;
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ivals[i] = new Interval(a, b);
        }
        
        Arrays.sort(ivals, 0, n, (o1, o2) -> o1.l - o2.l);
        
        boolean flag = false;
        int res = 0;
        // 双指针算法
        for (int i = 0; i < n; i ++) {
            int j = i, r = (int)-2e9;
            while (j < n && ivals[j].l <= st) {
                r = Math.max(ivals[j].r, r);
                j ++;
            }
            
            if (r < st) break;
            
            res ++;
            if (r >= ed) {
                flag = true; break;
            }
            
            st = r;
            i = j - 1;
        }
        
        if (flag) out.println(res);
        else out.println("-1");
        
        out.flush();
    }
    
    static class Interval {
        int l, r;
        Interval(int ll, int rr) {
            l = ll; r = rr;
        }
    }
}
