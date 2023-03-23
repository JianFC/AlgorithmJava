package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac789 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n, m;
    static int[] q = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        for (int i=0; i<n; i++) { ins.nextToken(); q[i] = (int)ins.nval; }
        
        while (m-- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            
            int l = 0, r = n-1;
            while (l < r) {     //二分右区间中答案
                int mid = l+r>>1;
                if (q[mid] >= x) r = mid;
                else l = mid+1;
            }
            
            if (q[l] != x) out.println("-1 -1");
            else {
                out.print(l+" ");
                
                l = 0; r = n-1;
                while (l < r) {
                    int mid = l+r+1>>1;
                    if (q[mid] <= x) l = mid;   //和单调性相反，二分左区间中答案
                    else r = mid-1;
                }
                
                out.println(r);
            }
        }

        out.flush();
    }
}

