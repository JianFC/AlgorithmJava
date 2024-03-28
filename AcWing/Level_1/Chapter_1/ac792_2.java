package AcWing.Level_1.Chapter_1;       //AcWing 792. 高精度减法

import java.io.*;
import java.math.*;

public class ac792_2 {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        out.println(new BigInteger(inb.readLine()).subtract(new BigInteger(inb.readLine())));
        out.flush();
    }
}
