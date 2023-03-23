package AcWing.Level_1.Chapter_4;

import java.io.*;
import java.util.*;

public class ac869 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static List<Integer> getDivisors(int x) {
        List<Integer> res = new ArrayList<>();
        
        for (int i=1; i<=x/i; i++) {
            if (x % i == 0) {
                res.add(i);
                
                if (i != x/i) res.add(x/i);
            }
        }
        
        res.sort((o1, o2) -> o1-o2);
        return res;
    } 
    
    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        
        while (n-- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            
            List<Integer> res = getDivisors(x);
            
            for (int p: res) out.print(p+" ");
            out.println();
        }

        out.flush();
    }
}
