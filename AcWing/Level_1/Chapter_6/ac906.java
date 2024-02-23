package AcWing.Level_1.Chapter_6;

import java.io.*;
import java.util.*;

public class ac906 {    //906. 区间分组
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static Range[] ranges = new Range[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) {
            ins.nextToken(); int l = (int)ins.nval;
            ins.nextToken(); int r = (int)ins.nval;
            ranges[i] = new Range(l, r);
        }
        
        //将区间按左端点从小到大排序
        Arrays.sort(ranges, 0, n, (o1, o2) -> o1.l - o2.l);
        
        //定义小根堆，记录各个分组中最大的右端点值，堆首元素即最大右端点的最小值
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i ++) {
            //堆空或右端点最小值>=range[i].l，新开一个分组
            if (heap.isEmpty() || heap.peek() >= ranges[i].l) heap.add(ranges[i].r);
            else {  // <range[i].l，加入最小值所在分组
                heap.poll();    //弹出堆
                heap.add(ranges[i].r);   //更新堆
            }
        }
        
        out.println(heap.size());

        out.flush();
    }
    
    static class Range {
        int l, r;
        Range(int ll, int rr) {
            l = ll; r = rr;
        }
    }
}
