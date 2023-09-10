package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac827 {    //827. 双链表
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int idx;
    static int[] l = new int[N], r = new int[N], e = new int[N];
    
    static void init() {    //0表示头节点，1表示尾结点，头尾结点只有指示作用实，idx从2开始
        r[0] = 1; l[1] = 0;
        idx = 2;
    }
    
    static void add(int k, int x) {     //在第k个插入的数右边插入一个结点
        e[idx] = x;
        l[idx] = k; r[idx] = r[k];
        l[r[k]] = idx; r[k] = idx++;
    }
    
    static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        init();
        
        while (n-- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            
            if (op.equals("L")) {
                ins.nextToken(); int x = (int)ins.nval;
                add(0, x);
            }
            else if (op.equals("R")) {
                ins.nextToken(); int x = (int)ins.nval;        
                add(l[1], x);
            }
            else if (op.equals("D")) {
                ins.nextToken(); int k = (int)ins.nval;
                remove(k + 1);
            }
            else if (op.equals("IL")) {
                ins.nextToken(); int k = (int)ins.nval;
                ins.nextToken(); int x = (int)ins.nval;
                add(l[k + 1], x);
            }
            else if (op.equals("IR")) {
                ins.nextToken(); int k = (int)ins.nval;
                ins.nextToken(); int x = (int)ins.nval;
                add(k + 1, x);
            }
        }
        
        for (int i = r[0]; i != 1; i = r[i]) out.print(e[i] + " ");

        out.flush();
    }
}
