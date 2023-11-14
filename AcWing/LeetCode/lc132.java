package AcWing.LeetCode;        //132. 分割回文串 II

class Solution {    //线性DP + 预处理区间状态数组
    public int minCut(String s) {
        int n = s.length();
        s = ' ' + s;    //下标从1开始
        boolean[][] g = new boolean[n + 1][n + 1];  //g[i][j]表示Si-Sj是否为回文串
        int[] f = new int[n + 1];   //f[i]代表从s1-si的所有分割方案
        
        for (int j = 1; j <= n; j ++)
            for (int i = 1; i <= n; i ++)
                if (i == j) g[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 > j - 1 || g[i + 1][j - 1]) g[i][j] = true;
                }

        Arrays.fill(f, 0x3f3f3f3f);     //初始化f
        f[0] = 0;
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= i; j ++)
                if (g[j][i])    //注意顺序！
                    f[i] = Math.min(f[i], f[j - 1] + 1);
        
        return f[n] - 1;    //分割方案 - 1 即 最少分割次数
    }
}
