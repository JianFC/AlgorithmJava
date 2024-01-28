package AcWing.Level_1.Chapter_1;

import java.io.*;
import java.util.*;

public class ac802 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 300010;

    static int n, m;
    static int[] a = new int[N], s = new int[N];
    static List<PII> ad = new ArrayList<>(), query = new ArrayList<>();
    static List<Integer> all = new ArrayList<>();

    static int unique(List<Integer> a) {
        int j = 0;
        for (int i = 0; i < a.size(); i++) {
            if (i == 0 || a.get(i) != a.get(i-1))
                a.set(j++, a.get(i));
        }
        return j;
    }

    static int find(int x) {
        int l = 0, r = all.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (all.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l + 1;     //前缀和从1开始
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;

        for (int i = 0; i < n; i++) {
            ins.nextToken(); int x = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            ad.add(new PII(x, c));
            all.add(x);
        }

        for (int i = 0; i < m; i++) {
            ins.nextToken(); int l = (int)ins.nval;
            ins.nextToken(); int r = (int)ins.nval;
            query.add(new PII(l, r));
            all.add(l); all.add(r);
        }

        Collections.sort(all);
        all = all.subList(0, unique(all));

        for (PII p: ad) {
            int x = find(p.first);
            a[x] += p.second;
        }

        for (int i = 1; i <= all.size(); i++) s[i] = s[i - 1] + a[i];   //预处理前缀和

        for (PII p: query) {
            int l = find(p.first), r = find(p.second);
            out.println(s[r] - s[l - 1]);
        }

        out.flush();
    }

    static class PII {
        int first, second;

        PII(int f, int s) {
            first = f; second = s;
        }
    }
}


