package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac148 {    //148. 合并果子
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        for (int i = 0; i < n; i++) {
            ins.nextToken(); int a = (int)ins.nval;
            heap.add(a);
        }
        
        int res = 0;
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            res += a + b;
            heap.add(a + b);
        }
        
        out.println(res);
        
        out.flush();
    }
}
