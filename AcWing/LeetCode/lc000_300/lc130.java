package AcWing.LeetCode;        //130. 被围绕的区域

class Solution {    //Flood Fill算法 + DFS实现 + 逆向思维
    char[][] board;
    int n, m;
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public void solve(char[][] _board) {
        board = _board;
        n = board.length;
        if (n == 0) return ;
        m = board[0].length;

        for (int i = 0; i < n; i ++) {
            if (board[i][0] == 'O') dfs(i, 0);  //第一列
            if (board[i][m - 1] == 'O') dfs(i, m - 1);  //最后一列
        }

        for (int i = 0; i < m; i ++) {
            if (board[0][i] == 'O') dfs(0, i);  //第一行
            if (board[n - 1][i] == 'O') dfs(n - 1, i);  //最后一行
        }

        //根据标记更新board
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                if (board[i][j] == '#') board[i][j] = 'O';
                else board[i][j] = 'X';
        
        _board = board;     //更新board
        
    }

    void dfs(int x, int y) {    //逆向思维，遍历边界上的O能到的位置
        board[x][y] = '#';  //标记，防止重复遍历，保证时间复杂度为O(n)
        for (int i = 0; i < 4; i ++) {
            int a = x + dx[i], b = y + dy[i];   //新位置
            if (a >= 0 && a < n && b >= 0 && b < m && board[a][b] == 'O')
                dfs(a, b);  //继续遍历
        }
    }
}