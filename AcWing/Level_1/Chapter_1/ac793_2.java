package AcWing.Level_1.Chapter_1;

import java.io.*;
import java.math.*;

public class ac793_2 {
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        out.print(new BigInteger(inb.readLine()).multiply(new BigInteger(inb.readLine())));

        out.flush();
    }
    
}
