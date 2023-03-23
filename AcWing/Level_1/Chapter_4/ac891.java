    package AcWing.Level_1.Chapter_4;

    import java.io.*;
    
    public class ac891 {    //891. Nim游戏
        static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
        public static void main(String[] args) throws Exception {
            ins.nextToken(); int n = (int)ins.nval;
            
            int res = 0;
            while (n-- > 0) {
                ins.nextToken(); int a = (int)ins.nval;
                res ^= a;
            }
            
            if (res != 0) out.println("Yes");
            else out.println("No");
    
            out.flush();
        }
    }
    