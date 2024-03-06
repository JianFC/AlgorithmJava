package AcWing.LeetCode;        //174. 地下城游戏

class Solution {    //DP数字三角形模型 + 注意分析思路
    public int calculateMinimumHP(int[][] w) {
        int n = w.length, m = w[0].length, INF = 0x3f3f3f3f;
        int[][] f = new int[n][m];                              //f[i][j]表示从(i, j)走到终点的路径集合的进入血量最小值
        for (int i = 0; i < n; i ++) Arrays.fill(f[i], INF);    //初始化f[i][j]为最大值

        for (int i = n - 1; i >= 0; i --)   //从终点往前dp
            for (int j = m - 1; j >= 0; j --)
                if (i == n - 1 && j == m - 1) f[i][j] = Math.max(1, 1 - w[i][j]);   //保证f[n - 1][m - 1]大于0
                else {
                    //f[i][j] = max(1, min(f[i + 1][j] - w[i][j], f[i][j + 1] - w[i][j]))   //保证时刻血量大于0
                    if (i + 1 < n) f[i][j] = f[i + 1][j] - w[i][j];
                    if (j + 1 < m) f[i][j] = Math.min(f[i][j], f[i][j + 1] - w[i][j]);
                    f[i][j] = Math.max(1, f[i][j]);     //时刻保证血量大于0
                }

        return f[0][0];     //最终f[0][0]存储答案
    }
}
