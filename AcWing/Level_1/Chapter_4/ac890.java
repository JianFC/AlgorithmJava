package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac890 {    //890. 能被整除的数
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int[] p = new int[20];

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;
        ins.nextToken(); int m = (int)ins.nval;
        
        for (int i=0; i<m; i++) { ins.nextToken(); p[i] = (int)ins.nval; }
        
        long res = 0;
        for (int i=1; i<1<<m; i++) {
            long t = 1, s = 0;
            
            for (int j=0; j<m; j++) {
                if ((i>>j & 1) == 1) {
                    s++;
                    
                    if (t*p[j] > n) {
                        t = -1;
                        break;
                    }
                    
                    t *= p[j];
                }
            }
                
            if (t != -1) {
                if (s % 2 == 0) res -= n/t;
                else res += n/t;
            }
        }
    
        out.println(res);
    
        out.flush();
    }
}
