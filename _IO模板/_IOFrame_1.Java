import java.io.*;
import java.util.*;

class Main {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    

    public static void main(String[] args) throws Exception {
        ins.nextToken(); 
        int n = (int)ins.nval; String s = (String)ins.sval;
        double x = (double)ins.nval;

        out.flush();
    }
}

