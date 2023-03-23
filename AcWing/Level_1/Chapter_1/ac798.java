package AcWing.Level_1.Chapter_1;

import java.io.*;

public class ac798 {
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    
    static int N = 1010;
    
    static int n, m, k;
    static int[][] a = new int[N][N], b = new int[N][N];
    
    static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2+1][y1] -= c;
        b[x1][y2+1] -= c;
        b[x2+1][y2+1] += c;
    }

    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        ins.nextToken(); k = (int)ins.nval;
        
        for (int i=1; i<=n; i++)
            for (int j=1; j<=m; j++) {
                ins.nextToken(); a[i][j] = (int)ins.nval;
                insert(i, j, i, j, a[i][j]);
            }
            
        while (k-- > 0) {
            ins.nextToken(); int x1 = (int)ins.nval;
            ins.nextToken(); int y1 = (int)ins.nval;
            ins.nextToken(); int x2 = (int)ins.nval;
            ins.nextToken(); int y2 = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            insert(x1, y1, x2, y2, c);
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                b[i][j] += b[i-1][j]+b[i][j-1]-b[i-1][j-1]; out.print(b[i][j]+" ");
            }
            out.print("\n");
        }

        out.flush();
    }
}
