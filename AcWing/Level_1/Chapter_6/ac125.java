package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac125 {    //125. 耍杂技的牛
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 500010;
    
    static int n;
    static Cow[] cows = new Cow[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) {
            ins.nextToken(); int w = (int)ins.nval;
            ins.nextToken(); int s = (int)ins.nval;
            cows[i] = new Cow(w + s, w);
        }
        
        //按w+s从小到大排序
        Arrays.sort(cows, 0, n, (o1, o2) -> (o1.l - o2.l));
        
        long res = (int)-2e9, sum = 0;
        for (int i = 0; i < n; i ++) {
            int s = cows[i].l - cows[i].r, w = cows[i].r;
            res = Math.max(res, sum - s);
            sum += w;
        }
        
        out.println(res);

        out.flush();
    }
    
    static class Cow {
        int l, r;
        Cow(int ll, int rr) {
            l = ll; r = rr;
        }
    }
}
