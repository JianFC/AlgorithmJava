package AcWing.LeetCode;
//44. 通配符匹配

class Solution {    //DP + 枚举 + 完全背包优化
    int N = 2010;

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s; p = " " + p;   //加上“ ”方便dp
        boolean[][] f = new boolean[N][N];  //f[i][j]代表的集合为s[1-i]和p[1-j]匹配的方案数的集合
                                            //boolean为状态表示的属性
        f[0][0] = true;     //空串和空串匹配
        for (int i = 0; i <= n; i ++) {  //注意下标从0开始，s空串可能和其他串匹配
            for (int j = 1; j <= m; j ++) {
                if (p.charAt(j) == '*') {
                    f[i][j] = f[i][j - 1] || i > 0 && f[i - 1][j];  //枚举*匹配几个字符，优化思路类似完全背包
                }
                else {     //当p[j] 不等于*
                    f[i][j] = i > 0 && f[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'); 
                }
            }
        }

        return f[n][m];
    }
}
