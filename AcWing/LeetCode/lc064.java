package AcWing.LeetCode;

class Solution {    //基础线性DP
    public int minPathSum(int[][] g) {
        int n = g.length;
        if (n == 0) return 0;
        int m = g[0].length;
        int[][] f = new int[n][m];  //f[i][j]代表从(0, 0)到(i, j)的路径和的最小值
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) f[i][j] = 0x3f3f3f3f;   //初始化f[i][j]

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (i == 0 && j == 0) f[i][j] = g[i][j];
                else {  //f[i][j] = min(f[i-1][j], f[i][j-1]) + g[i][j]
                    if (i > 0) f[i][j] = Math.min(f[i][j], f[i - 1][j] + g[i][j]);
                    if (j > 0) f[i][j] = Math.min(f[i][j], f[i][j - 1] + g[i][j]);
                }
        
        return f[n - 1][m - 1];
    }
}