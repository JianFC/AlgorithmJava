package AcWing.LeetCode;

class Solution {    //线性DP+思维题+字符串
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (s3.length() != n + m) return false;     //长度不一致
        s1 = " " + s1; s2 = " " + s2; s3 = " " + s3;    //有效字符下标从1开始
        boolean[][] f = new boolean[n + 1][m + 1];  //f[i][j]表示s1[1, i]和s2[1, j]能否拼成s3[1, i+j]
        
        for (int i = 0; i <= n; i++)    //从0开始
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) f[i][j] = true;    //空串和空串可以拼成空串, 初始化边界
                else {      //f[i][j]  = f[i-1][j] || f[i][j-1]
                    if (i > 0 && s1.charAt(i) == s3.charAt(i + j)) 
                        f[i][j] = f[i - 1][j];
                    if (j > 0 && s2.charAt(j) == s3.charAt(i + j))
                        f[i][j] = f[i][j] || f[i][j - 1];
                }
            }

        return f[n][m];
    }
}