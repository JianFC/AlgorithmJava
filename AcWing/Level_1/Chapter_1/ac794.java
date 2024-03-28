package AcWing.Level_1.Chapter_1;       //AcWing 794. 高精度除法

import java.io.*;
import java.util.*;

public class ac794 {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static List<Integer> div(List<Integer> A, int b, int[] rr) {
        List<Integer> res = new ArrayList<>(); int r = rr[0];
        
        for (int i = A.size() - 1; i >= 0; i --) {
            r = r * 10 + A.get(i);
            res.add(r / b);
            r = r % b;
        }
        
        Collections.reverse(res); rr[0] = r;
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        String a = inb.readLine(); int b = Integer.parseInt(inb.readLine()); int[] rr = {0};
        
        List<Integer> A = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        
        for (int i = a.length() - 1; i >= 0; i --) A.add(a.charAt(i)-'0');
        
        C = div(A, b, rr);
        
        for (int i = C.size() - 1; i >= 0; i --) out.print(C.get(i));
        out.print("\n" + rr[0]);

        out.flush();
    }
}
