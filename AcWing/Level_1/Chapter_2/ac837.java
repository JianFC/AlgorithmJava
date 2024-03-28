package AcWing.Level_1.Chapter_2;        //AcWing 837. 连通块中点的数量

import java.io.*;

public class ac837 {   
    static BufferedReader inb = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 100010;

    static int n, m;
    static int[] p = new int[N], cnt = new int[N];

    static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws Exception {
        String[] ss = inb.readLine().split(" ");
        n = Integer.parseInt(ss[0]); m = Integer.parseInt(ss[1]);

        for (int i = 1; i <= n; i ++) { p[i] = i; cnt[i] = 1; }

        while (m -- > 0) {
            ss = inb.readLine().split(" ");

            if (ss[0].equals("C")) {
                int a = Integer.parseInt(ss[1]), b = Integer.parseInt(ss[2]);

                a = find(a); b = find(b);
                p[a] = b;
                if (a != b) cnt[b] += cnt[a];
            }
            else if (ss[0].equals("Q1")) {
                int a = Integer.parseInt(ss[1]), b = Integer.parseInt(ss[2]);

                if (find(a) == find(b)) out.println("Yes");
                else out.println("No");
            }
            else {
                int a = Integer.parseInt(ss[1]);

                out.println(cnt[find(a)]);
            }
        }

        out.flush();
    }
}
