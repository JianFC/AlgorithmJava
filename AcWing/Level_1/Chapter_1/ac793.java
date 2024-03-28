package AcWing.Level_1.Chapter_1;       //AcWing 793. 高精度乘法

import java.io.*;
import java.util.*;

public class ac793 {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static List<Integer> mul(List<Integer> A, int b) {
         List<Integer> res = new ArrayList<>();
         
         for (int i = 0, t = 0; i < A.size() || t > 0; i ++) {
             if (i < A.size()) t += A.get(i) * b;
             res.add(t % 10);
             t /= 10;
         }
         
         while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
         
         return res;
    }

    public static void main(String[] args) throws Exception {
        String a = inb.readLine(); int b = Integer.parseInt(inb.readLine());
        
        List<Integer> A = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        
        for (int i = a.length() - 1; i >= 0; i --) A.add(a.charAt(i)-'0');
        
        C = mul(A, b);
        
        for (int i = C.size() - 1; i >= 0; i --) out.print(C.get(i));

        out.flush();
    }
}
