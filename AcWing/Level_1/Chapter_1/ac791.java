package AcWing.Level_1.Chapter_1;      //AcWing 791. 高精度加法

import java.io.*;
import java.util.*;

public class ac791 { 
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static List<Integer> add(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0, t = 0; i < A.size() || i < B.size() || t > 0; i ++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            res.add(t % 10);
            t /= 10;
        }
        
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        String a = inb.readLine(), b = inb.readLine();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        
        for (int i = a.length() - 1; i >= 0; i --) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i --) B.add(b.charAt(i) - '0');
        
        C = add(A, B);
        
        for (int i = C.size() - 1; i >= 0; i --) out.print(C.get(i));

        out.flush();
    }
    
}
