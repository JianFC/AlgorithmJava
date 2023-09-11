package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac905 {    //905. 区间选点
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static Interval[] ivals = new Interval[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ivals[i] = new Interval(a, b);
        }
        
        //按右端点升序排列所有区间，Comparator函数 = sign(o1.r-o2.r)，1交换元素位置，0和-1则不变
        Arrays.sort(ivals, 0, n, (o1, o2) -> o1.r - o2.r);
        
        int res = 0, ed = (int)-2e9;     //ed初始化当前所有区间最右点为-2e9
        for (int i = 0; i < n; i++) {
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
