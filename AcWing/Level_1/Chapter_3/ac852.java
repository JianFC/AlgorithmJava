package AcWing.Level_1.Chapter_3;           //AcWing 852. spfa判断负环

import java.io.*;
import java.util.*;

public class ac852 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 2010, M = 10010;
    
    static int n, m;
    static int idx;
    static int[] h = new int[N], e = new int[M], w = new int[M], ne = new int[M];
    static Queue<Integer> q = new LinkedList<Integer>();
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N], cnt = new int[N];   //cnt[i]表示初始某个点到结点i的路径边数。
    
    static void add(int a, int b, int c) {
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx ++;
    }
    
    static boolean spfa() {
        //存在负权边，所以dist可以不用初始化为INF
        for (int i = 1; i <= n; i ++) {
            q.offer(i); st[i] = true;   //初始将所有点加入q中
        }
        
        while (!q.isEmpty()) {
            int t = q.poll();
            st[t] = false;  //出队
            
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;  //到达j的路径边数=到达t的路径边数+1
                    
                    if (cnt[j] >= n) return true;
                    
                    if (!st[j]) {
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        
        Arrays.fill(h, -1);
        
        while (m-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            add(a, b, c);
        }
        
        out.println((spfa() ? "Yes" : "No"));

        out.flush();
    }
}
