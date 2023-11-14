package AcWing.LeetCode;        //87. 扰乱字符串

class Solution {    //区间DP + 状态划分 + 思维题 + 状态计算分析
    public boolean isScramble(String s1, String s2) {   //DP，时间复杂度O(n^4)
        int n = s1.length(), m = s2.length();
        //f[i][j][k]集合表示将s1[i, i + k - 1]变为s2[j, j + k - 1]的方案数，属性为是否存在
        boolean[][][] f = new boolean[n][m][n + 1];

        for (int k = 1; k <= n; k ++)  //首先枚举区间长度，从1 - n
            for (int i = 0; i + k - 1 < n; i ++)     //保证区间末尾合法
                for (int j = 0; j + k - 1 < n; j ++) {
                    if (k == 1) {   //k == 1时，算法结束，直接判断是否相等
                        if (s1.charAt(i) == s2.charAt(j))
                            f[i][j][k] = true;
                    }
                    else {
                        for (int u = 1; u < k; u ++)
                            //不交换or交换
                            if (f[i][j][u] && f[i + u][j + u][k - u] || 
                                f[i][j + k - u][u] && f[i + u][j][k - u]) {
                                    f[i][j][k] = true;
                                    break;  //只要有一种合法方案即可break
                                }
                    } 
                }
        
        return f[0][0][n];
    }
}
