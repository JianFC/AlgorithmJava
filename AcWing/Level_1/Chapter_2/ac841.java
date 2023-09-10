package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac841 {    //841. 字符串哈希
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, P = 131;
    
    static int n, m;
    //Java中无unsigned long long类型，此处用long类型替代，范围是-2^63-2^63-1，即Q从2^64变为2^63。
    static long[] h = new long[N], p = new long[N];
    
    static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    public static void main(String[] args) throws Exception {
        String[] ss = inb.readLine().split(" ");
        n = Integer.parseInt(ss[0]); m = Integer.parseInt(ss[1]);
        String str = " " + inb.readLine();    //不能用ins.sval，字符串长度超过缓存
        
        //预处理h和p数组
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + str.charAt(i);
        }
        
        while (m-- > 0) {
            String[] tp = inb.readLine().split(" ");
            int l1 = Integer.parseInt(tp[0]);
            int r1 = Integer.parseInt(tp[1]);
            int l2 = Integer.parseInt(tp[2]);
            int r2 = Integer.parseInt(tp[3]);
            
            if (get(l1, r1) == get(l2, r2)) out.println("Yes");
            else out.println("No");
        }

        out.flush();
    }
}
