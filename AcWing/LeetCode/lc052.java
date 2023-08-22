package AcWing.LeetCode;

class Solution {    //DFS + 直线斜率优化
    int N = 10;
    
    int n, res = 0;
    boolean[] col = new boolean[N], dg = new boolean[2 * N], udg = new boolean[2 * N];

    public int totalNQueens(int _n) {
        n = _n;
        dfs(0);

        return res;
    }

    void dfs(int u) {
        if (u == n) {
            res++;  //找到一种合法方案
            return;
        }

        for (int i = 0; i < n; i++) {   //枚举改行哪些列可以放置皇后
            if (!col[i] && !dg[i + u] && !udg[i - u + n]) {
                col[i] = dg[i + u] = udg[i - u + n] = true;
                dfs(u + 1);
                col[i] = dg[i + u] = udg[i - u + n] = false;    //恢复现场
            }
        }
    }
}
