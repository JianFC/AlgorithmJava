package AcWing.Level_1.Chapter_2;

import java.io.*;
import java.util.*;

//拉链法
public class ac840_2 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 100003;

    static int n;
    static int[] h = new int[N], e = new int[N], ne = new int[N];
    static int idx;

    static void insert(int x) {
        int k = (x % N+N) % N;

        e[idx] = x; ne[idx] = h[k]; h[k] = idx++;
    }

    static boolean find(int x) {
        int k = (x % N+N) % N;

        for (int i=h[k]; i!=-1; i=ne[i])
            if (e[i] == x) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        // for (int i=100000; true; i++) {
        //     int flag = 1;
        //     for (int j=2; j<=i/j; j++) {
        //         if (i % j == 0) {
        //             flag = 0;
        //             break;
        //         }
        //     }

        //     if (flag == 1) {
        //         out.println(i);
        //         break;
        //     }
        // }
        Arrays.fill(h, -1);
        ins.nextToken(); n = (int)ins.nval;

        while (n-- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            ins.nextToken(); int x = (int)ins.nval;

            if (op.equals("I")) insert(x);
            else 
                if (find(x)) out.println("Yes");
                else out.println("No");
        }

        out.flush();
    }
}
