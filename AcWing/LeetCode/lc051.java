package AcWing.LeetCode;

class Solution {    //DFS+直线斜率优化
    int N = 15;
    
    int n;
    List<List<String>> res = new ArrayList<>();
    char[][] g = new char[N][N];
    boolean[] col = new boolean[N], dg = new boolean[2 * N], udg = new boolean[2 * N];

    public List<List<String>> solveNQueens(int k) {
        n = k;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) g[i][j] = '.';
        
        dfs(0);

        return res;
    }

    void dfs(int u) {
        if (u == n) {   //找到一种合法答案
            List<String> row = new ArrayList<>();
            for (int i = 0; i < n; i++) row.add(String.valueOf(g[i], 0, n));
            res.add(row);
            return;
        }

        for (int i = 0; i < n; i++) {   //枚举第u行能放皇后的列
            if (!col[i] && !dg[i + u] && !udg[i - u + n]) {
                g[u][i] = 'Q';
                col[i] = dg[i + u] = udg[i - u + n] = true;
                dfs(u + 1);
                g[u][i] = '.';       //恢复现场
                col[i] = dg[i + u] = udg[i - u + n] = false;
            }
        }
    }
 }