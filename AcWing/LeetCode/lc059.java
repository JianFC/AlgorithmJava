package AcWing.LeetCode;

class Solution {    //方向向量
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for (int i = 1, x = 0, y = 0, d = 0; i <= n * n; i++) {
            res[x][y] = i;  //更新res

            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= n || res[a][b] != 0) {
                d = (d + 1) % 4;    //更新d
                a = x + dx[d]; b = y + dy[d];
            }
            x = a; y = b;   //更新x和y
        }

        return res;
    }
}
