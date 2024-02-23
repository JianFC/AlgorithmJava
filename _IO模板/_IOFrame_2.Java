import java.io.*;
import java.util.*;

class Main {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {
        String s = inb.readLine();
        char[] sarr = s.toCharArray();
        
        
        String[] ss = inb.readLine().split(" +"); 
        int n = Integer.parseInt(ss[0]); long ln = Long.parseLong(ss[0];)

        //备注: StreamTokenizer读取大于10^16的整数时会发生精度丢失
        String[] tmp = inb.readLine().split("\\s+");
        // \\s表示空格,回车,换行等空白符, +号表示一个或多个的意思

        out.flush();
    }
}