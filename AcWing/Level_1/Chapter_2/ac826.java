package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac826 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int head, idx;   //head表示头节点的下标，idx表示当前已经使用到了哪个点
    static int[] e = new int[N], ne = new int[N];   // e[i]表示结点i的值，ne[i]表示节点i的next指针
    
    static void init() {
        head = -1; idx = 0;
    }
    
    static void addToHead(int x) {
        e[idx] = x; ne[idx] = head; head = idx ++;
    }
    
    static void add(int k, int x) {
        e[idx] = x; ne[idx] = ne[k]; ne[k] = idx ++;
    }
    
    static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        init(); //记得初始化
        
        while (n -- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            
            if (op.equals("H")) {
                ins.nextToken(); int x = (int)ins.nval;
                addToHead(x);
            }
            else if (op.equals("D")) {
                ins.nextToken(); int k = (int)ins.nval;
                if (k == 0) head = ne[head];
                else remove(k - 1);
            }
            else if (op.equals("I")) {
                ins.nextToken(); int k = (int)ins.nval;
                ins.nextToken(); int x = (int)ins.nval;
                add(k - 1, x);
            }
        }
        
        for (int i = head; i != -1; i = ne[i]) out.print(e[i] + " ");

        out.flush();
    }
}
