package AcWing.LeetCode;        //62. 不同路径

class Solution {    //基础线性DP
    public int uniquePaths(int n, int m) {
        int[][] f = new int[n][m];  //f[i][j]代表从起点到(i, j)的路径数
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                if (i == 0 && j == 0) f[i][j] = 1;
                else {  //f[i, j] = f[i - 1, j] + f[i, j - 1]
                    if (i > 0) f[i][j] += f[i - 1][j];
                    if (j > 0) f[i][j] += f[i][j - 1];  
                }
        
        return f[n - 1][m - 1];
    }
}