package AcWing.Level_1.Chapter_1;

import java.io.*;
import java.util.*;

public class ac803 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static List<PII> segs = new ArrayList<>();
    
    static int merge(List<PII> segs) {
        List<PII> res = new ArrayList<>();
        
        segs.sort((o1, o2) -> o1.first - o2.first);   //sort参数>0交换，<0不交换
        
        int st = (int)-2e9, ed = (int)-2e9;
        for (PII seg: segs) {
            if (ed < seg.first) {
                if (ed != -2e9) res.add(new PII(st, ed));
                st = seg.first; ed = seg.second;
            }
            ed = Math.max(ed, seg.second);
        }
        
        if (st != -2e9) res.add(new PII(st, ed));
        
        return res.size();
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int l = (int)ins.nval;
            ins.nextToken(); int r = (int)ins.nval;
            segs.add(new PII(l, r));
        }
        
        out.print(merge(segs));

        out.flush();
    }
    
    static class PII {
        int first, second;
        
        PII(int f, int s) { 
            first = f; second = s; 
        }
    }
}