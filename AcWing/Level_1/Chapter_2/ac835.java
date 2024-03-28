package AcWing.Level_1.Chapter_2;       //AcWing 835. Trie字符串统计

import java.io.*;

public class ac835 {    //835. Trie字符串统计
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];
    static int idx; //编号为0的点既是根节点，也是空结点
    
    static void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i ++) {
            int u = s.charAt(i)-'a';
            if (son[p][u] == 0) son[p][u] = ++ idx;
            p = son[p][u];
        }
        
        cnt[p] ++;
    }
    
    static int query(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i ++) {
            int u = s.charAt(i)-'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        
        return cnt[p];
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(inb.readLine());
        
        while (n -- > 0) {
            String[] ss = inb.readLine().split(" ");
            
            if (ss[0].equals("I")) insert(ss[1]);
            else out.println(query(ss[1]));
        }

        out.flush();
    }
    
}
