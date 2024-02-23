package AcWing.Level_1.Chapter_2;

import java.io.*;

public class ac240 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 50010;
    
    static int n, k;
    static int[] p = new int[N], d = new int[N];    //d维护每个结点到根结点的距离信息
    
    static int find(int x) {
        if (x != p[x]) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        
        return p[x];
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); k = (int)ins.nval;
        
        for (int i = 1; i <= n; i ++) p[i] = i;
        
        int res = 0;
        while (k-- > 0) {
            ins.nextToken(); int t = (int)ins.nval;
            ins.nextToken(); int x = (int)ins.nval;
            ins.nextToken(); int y = (int)ins.nval;
            
            if (x > n || y > n) res++;
            else {
                if (t == 1) {
                    int px = find(x), py = find(y);
                    if (px == py && (d[x] - d[y]) % 3 != 0) res++;
                    else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x];
                    }
                }
                else if (t == 2){
                    int px = find(x), py = find(y);
                    if (px == py && (d[x] - d[y] + 1) % 3 != 0) res++;
                    else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x] - 1;
                    }
                }
            } 
        }
        
        out.println(res);

        out.flush();
    }
}
