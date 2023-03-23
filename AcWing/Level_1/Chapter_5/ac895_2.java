package AcWing.Level_1.Chapter_5;

import java.io.*;

public class ac895_2 {    //895. 最长上升子序列_打印路径
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010;
    
    static int n;
    static int[] a = new int[N], f = new int[N], g = new int[N];    //g存储转移的过程

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i=1; i<=n; i++) { ins.nextToken(); a[i] = (int)ins.nval; }
        
        for (int i=1; i<=n; i++) {
            f[i] = 1;   //没有第i-1个数
            g[i] = 0;   //前驱是0
            for (int j=1; j<i; j++)
                if (a[j] < a[i])
                    if (f[i] < f[j]+1) {
                        f[i] = f[j]+1;
                        g[i] = j;
                    }
        }
        
        //找出答案
        int k = 1;
        for (int i=1; i<=n; i++)
            if (f[i] > f[k]) k = i;
        
        out.println(f[k]);
        
        //打印路径
        for (int i=0, len=f[k]; i<len; i++) {
            out.print(a[k]+" ");
            k = g[k];
        }

        out.flush();
    }
}
