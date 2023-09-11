package AcWing.Level_1.Chapter_4;

import java.io.*;

public class ac889 {    //889. 满足条件的01序列
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int mod = (int)1e9 + 7;

    static long qmi(long a, long k, long p) {
        long res = 1 % p;
        while (k > 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); int n = (int)ins.nval;

        int a = 2 * n, b = n;
        long res = 1;
        for (int i = 1, j = a; i <= b; i++, j--) {
            res = res * j % mod;
            res = res * qmi(i, mod - 2, mod) % mod;
        }

        res = res * qmi(n + 1, mod - 2, mod) % mod;
        out.println(res);

        out.flush();
    }
}
