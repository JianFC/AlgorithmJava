package AcWing.Level_1.Chapter_2;       //AcWing 143. 最大异或对

import java.io.*;

public class ac143 {    //143. 最大异或对
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010, M = 31*N;
    
    static int n;
    static int[] a = new int[N];
    static int[][] son = new int[M][2]; 
    static int idx;
    //由于每个整数固定用31位表示，故不需要结束标记数组
    
    static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i --) {
            int u = x >> i & 1;
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }
    
    static int query(int x) {   //找出x的异或最大值
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i --) {
            int u = x >> i & 1;
            if (son[p][1 - u] != 0) {
                res += 1 << i;
                p = son[p][1 - u];    //注意使用son[p][1-u]更新p
            }
            else p = son[p][u];
        }
        
        return res;
    }
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        for (int i = 0; i < n; i ++) { 
            ins.nextToken(); a[i] = (int)ins.nval; 
            insert(a[i]);    
        }
        
        int res = 0;
        for (int i = 0; i < n; i ++) res = Math.max(res, query(a[i]));   //循环求出全局最大
        
        out.print(res);
    
        out.flush();
    }
}
