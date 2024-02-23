package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac828 {    //828. 模拟栈
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int tt;  //栈顶指针
    static int[] stk = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        while (n -- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            
            if (op.equals("push")) {
                ins.nextToken(); int x = (int)ins.nval;
                stk[++tt] = x;
            }
            else if (op.equals("pop")) tt --;
            else if (op.equals("empty")) {
                if (tt > 0) out.println("NO");
                else out.println("YES");
            }
            else out.println(stk[tt]);
        }
     
        out.flush();
    }
}
