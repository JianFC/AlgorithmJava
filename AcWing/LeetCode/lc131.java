package AcWing.LeetCode;

class Solution {    //暴搜方案(时间复杂度O(2^n-1)) + 递推优化 + DFS
    int N = 20;
    boolean[][] f = new boolean[N][N];  //递推求f[i][j],表示si - sj是否为回文串，优化暴搜时间复杂度
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n  = s.length();
        
        for (int j = 0; j < n; j ++)    //因为f[i][j] 需要f[i + 1][j - 1],所以要先枚举j
            for (int i = 0; i <= j; i ++)
                if (i == j) f[i][j] = true; //只包含一个字符，是回文串
                else if (s.charAt(i) == s.charAt(j)) {       //当s[i] == s[j]时
                    if (i + 1 > j - 1 || f[i + 1][j - 1])   //只有两个字符or 上一层f[i + 1][j - 1]为true
                        f[i][j] = true;
                }
        
        dfs(s, 0);  //从第0个位置开始搜
        return res;
    }

    void dfs(String s, int u) {
        if (u == s.length()) res.add(new ArrayList(path));  //找到一种方案
        else {
            for (int i = u; i < s.length(); i ++)
                if (f[u][i]) {  //递推优化时间复杂度
                    path.add(s.substring(u, i + 1));    //截取回文串
                    dfs(s, i + 1);  //递归搜索
                    path.remove(path.size() - 1);   //回复现场
                }
        }
    }
}