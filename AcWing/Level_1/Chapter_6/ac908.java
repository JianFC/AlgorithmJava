package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac908 {    //908. 最大不相交区间数量
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static Interval[] ivals = new Interval[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i=0; i<n; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ivals[i] = new Interval(a, b);
        }
        
        //按右端点升序排列区间
        Arrays.sort(ivals, 0, n, (o1, o2) -> o1.r-o2.r);
        
        int res = 0, ed = (int)-2e9;    //与区间选点贪心思路一致
        for (int i=0; i<n; i++) {
            if (ivals[i].l > ed) {
                res++;
                ed = ivals[i].r;    //更新ed
            }
        }
        
        out.println(res);

        out.flush();
    }
    
    static class Interval {
        int l, r;
        Interval(int ll, int rr) {
            l = ll; r = rr;
        }
    }
}
