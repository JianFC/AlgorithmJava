package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac896 {    //896. 最长上升子序列 II
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[] q = new int[N];
    static int len;
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        q[0] = (int)-2e9;   //设置哨兵
        while (n -- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            
            //二分左边界
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < a) l = mid;
                else r = mid - 1;
            }
            
            len = Math.max(len, r + 1);
            q[r + 1] = a;
        }
        
        out.println(len);

        out.flush();
    }
}
