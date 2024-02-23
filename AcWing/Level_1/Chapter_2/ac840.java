package AcWing.Level_1.Chapter_2;

import java.io.*;
import java.util.*;

//开放寻址法
public class ac840 {    //AcWing 840. 模拟散列表
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 200003, nul = 0x3f3f3f3f;

    static int n;
    static int[] h = new int[N];


    //当x存在时返回x存储的位置，不存在时返回应该存储的位置
    static int find(int x) {
        int k = (x % N + N) % N;

        while (h[k] != nul && h[k] != x) {
            k ++;
            if (k == N) k = 0; 
        }

        return k;
    }


    public static void main(String[] args) throws Exception {
        // for (int i = 200000; true; i ++) {
        //     int flag = 1;
        //     for (int j = 2; j <= i / j; j ++)
        //         if (i % j == 0) {
        //             flag = 0;
        //             break;
        //         }
        //     if (flag == 1) {
        //         out.println(i);
        //         break;
        //     }
        // }
        Arrays.fill(h, nul);
        ins.nextToken(); n = (int)ins.nval;

        while (n -- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            ins.nextToken(); int x = (int)ins.nval;

            if (op.equals("I")) h[find(x)] = x;
            else
                if (h[find(x)] == x) out.println("Yes");
                else out.println("No");
        }

        out.flush();
    }
}
