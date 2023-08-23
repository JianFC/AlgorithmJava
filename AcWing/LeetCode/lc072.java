package AcWing.LeetCode;

class Solution {    //基础线性DP+编辑距离模板题
    public int minDistance(String a, String b) {
        int n = a.length(), m = b.length();
        a = " " + a; b = " " + b;   //从 1开始处理
        int[][] f = new int[n + 1][m + 1];  //f[i][j]代表a[1-i]按顺序变成b[1-j]的方案的最小操作数

        //初始化f[i][j]
        for (int i = 0; i <= n; i++) f[i][0] = i;
        for (int i = 0; i <= m; i++) f[0][i] = i;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;  //删除or增加子集
                int t = a.charAt(i) == b.charAt(j)? 0: 1;   //修改子集
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + t);
            }

        return f[n][m];
    }
}
