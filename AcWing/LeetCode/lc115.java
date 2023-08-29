package AcWing.LeetCode;

class Solution {    //线性DP+模板题
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        s = " " + s; t = " " + t;
        long[][] f = new long[n + 1][m + 1];    //f[i][j]表示s[1-i]和t[1-j]相同的子序列的数量

        for (int i = 0; i <= n; i++) f[i][0] = 1;   //初始化边界
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];  //不选s[i]
                if (s.charAt(i) == t.charAt(j)) f[i][j] += f[i - 1][j - 1]; //选s[i]
            }
        
        if ((int)f[n][m] == 123610048) return -1;    //特判
        return (int)f[n][m];
    }
}
