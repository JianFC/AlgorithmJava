package AcWing.Level_1.Chapter_2;       //AcWing 836. 合并集合

import java.io.*;

public class ac836 {    //acwing836 合并集合
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 100010;

    static int n, m;
    static int[] p = new int[N];

    static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;

        for (int i = 1; i <= n; i ++) p[i] = i;

        while (m -- > 0) {
            ins.nextToken(); String op = (String)ins.sval;
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;

            if (op.equals("M")) p[find(a)] = find(b);
            else {
                if (find(a) == find(b)) out.println("Yes");
                else out.println("No");
            }
        }

        out.flush();
    }
}
