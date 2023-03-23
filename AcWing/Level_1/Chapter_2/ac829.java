package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac829 {    //829. 模拟队列
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 100010;
    
    static int n;
    static int hh, tt = -1;
    static int[] q = new int[N];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            
            if (op.equals("push")) {
                ins.nextToken(); int x = (int)ins.nval;
                q[++tt] = x;
            }
            else if (op.equals("pop")) hh++;
            else if (op.equals("empty")) {
                if (hh <= tt) out.println("NO");
                else out.println("YES");
            }
            else out.println(q[hh]);
        }

        out.flush();
    }
}
