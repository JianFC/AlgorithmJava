package AcWing.Level_1.Chapter_1;

import java.io.*;
import java.util.*;

public class ac792 {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static boolean cmp(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) return A.size() > B.size();
        else {
            for (int i = A.size() - 1; i >= 0; i--)
                if (A.get(i) != B.get(i)) return A.get(i) > B.get(i);
        }
        
        return true;
    }
    
    static List<Integer> sub(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0, t = 0; i < A.size() || t > 0; i++) {
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            res.add((t + 10) % 10);
            t = t < 0 ? 1 : 0;
        }
        
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        String a = inb.readLine(), b = inb.readLine();
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        List<Integer> C = new ArrayList<Integer>();
        
        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');
        
        if (cmp(A, B)) C = sub(A, B);
        else { out.print("-"); C = sub(B, A); }
        
        for (int i = C.size() - 1; i >= 0; i--) out.print(C.get(i));
        
        out.flush();
    }
    
}
