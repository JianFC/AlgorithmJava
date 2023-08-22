package AcWing.LeetCode;

class Solution {    //基础线性DP
    public int uniquePathsWithObstacles(int[][] o) {
        int n = o.length;
        if (n == 0) return 0;
        int m = o[0].length;
        int[][] f = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (o[i][j] == 0) {     //当(i, j)为空时可以走
                    if (i == 0 && j == 0) f[i][j] = 1;
                    else {
                        if (i > 0) f[i][j] += f[i - 1][j];
                        if (j > 0) f[i][j] += f[i][j - 1];
                    }
                }

        return f[n - 1][m - 1];
    }
}