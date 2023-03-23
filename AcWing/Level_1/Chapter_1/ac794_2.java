package AcWing.Level_1.Chapter_1;

import java.io.*;
import java.math.*;

public class ac794_2 {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BigInteger a = new BigInteger(inb.readLine()), b = new BigInteger(inb.readLine());

        out.print(a.divide(b) + "\n" + a.mod(b));

        out.flush();
    }
    
}
