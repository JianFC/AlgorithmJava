package AcWing.LeetCode;        //10. 正则表达式匹配

class Solution {    // 线性DP
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s; p = " " + p;   //从下标1开始dp

        boolean[][] f = new boolean[n + 1][m + 1];  //dp
        f[0][0] = true; //边界情况

        for (int i = 0; i <= n; i ++) {      //注意从0开始，当s为空时，可能匹配
            for (int j = 1; j <= m; j ++) {
                // if (j + 1 <= m && p.charAt(j + 1) == '*') continue;    //把*和前面的字符视为一个整体处理，处理s = "abc", p = "a***abc"数据

                if (p.charAt(j) != '*') {   //不等于*
                    f[i][j] = i > 0 && f[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                }
                else {  //等于*
                    f[i][j] = f[i][j - 2] || ( i > 0 && f[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'));
                }

            }
        }

        return f[n][m];
    }
}

/* 
DP分析
状态表示：
    集合s；f[i, j]关联的集合表示s[1, i]和p[1, j]能够匹配的方案数
    属性a: f[i, j]代表是否存在方案, bool值
状态计算：
    p[j] != *, f[i, j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.')
    p[j] == *, f[i, j] = f[i][j - 2] (匹配0个p[j]) || f[i - 1][j - 2] ^ Si(匹配1个p[j]) || f[i - 2][j - 2] ^ Si ^ Si-1 || f[i - 3][j - 2] ^ Si ^ Si-1 ^ Si-2 || ...
        且当p[j] == *时, f[i - 1][j] =                f[i - 1][j - 2]                   || f[i - 2][j - 2] ^ Si-1      || f[i - 3][j - 2] ^ Si-1 ^ Si-2     || ...
        故当p[j] == *时，f[i][j] = f[i][j - 2] || (f[i - 1][j] ^ Si)，并以此进行优化

*/