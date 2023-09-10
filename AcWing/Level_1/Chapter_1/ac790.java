package AcWing.Level_1.Chapter_1;

import java.io.*;
import java.util.*;

public class ac790 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static double eps = 1e-8;

    public static void main(String[] args) throws Exception {
        double x = in.nextDouble();
        
        double l = -100, r = 100;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= x) r = mid;
            else l = mid;
        }
        
        out.printf("%.6f", l);

        out.flush();
    }
    
}
