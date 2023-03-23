package AcWing.Level_1.Chapter_3;

import java.io.*;

public class ac854 {    //AcWing 854. Floyd求最短路
    static StreamTokenizer ins = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int N = 210, INF = 0x3f3f3f3f;

    static int n, m, q;
    static int[][] dist = new int[N][N];

    static void floyd() {
        for (int k=1; k<=n; k++)
            for (int i=1; i<=n; i++)
                for (int j=1; j<=n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
    }


    public static void main(String[] args) throws Exception {
        ins.nextToken(); n = (int)ins.nval;
        ins.nextToken(); m = (int)ins.nval;
        ins.nextToken(); q = (int)ins.nval;

        for (int i=1; i<=n; i++)
            for (int j=1; j<=n; j++)
                dist[i][j] = (i == j ? 0: INF);

        while (m-- > 0) {
            ins.nextToken(); int a = (int)ins.nval;
            ins.nextToken(); int b = (int)ins.nval;
            ins.nextToken(); int c = (int)ins.nval;
            dist[a][b] = Math.min(dist[a][b], c);
        }

        floyd();

        while (q-- > 0) {
            ins.nextToken(); int x = (int)ins.nval;
            ins.nextToken(); int y = (int)ins.nval;
            out.println((dist[x][y] > INF/2 ? "impossible": dist[x][y]));
        }

        out.flush();
    }
}
