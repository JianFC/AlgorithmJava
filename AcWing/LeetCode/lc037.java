package AcWing.LeetCode;

class Solution {    //DFS+n皇后变种+状态表示和存储
    //分别代表1-9行（列）1-9这几个数字是否出现过
    boolean[][] row = new boolean[9][9], col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];  //9个cell中1-9是否出现过
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    //第i行，第j列，第[i / 3][j / 3]个cell中t+1已经出现过
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }

        
        dfs(board, 0, 0);   //从左上角开始dfs
    }

    boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            x++; y = 0;     //y移到一行的末尾，更新x，y
        }
        if (x == 9) return true;    //找到一个解

        if (board[x][y] != '.') return dfs(board, x, y+1);  //当前位置已经有数，处理下一个位置

        //当前位置没有数
        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {   //条件检查
                board[x][y] = (char)(i + '1');  //更新board[x][y]
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;   //更新状态数组
                if(dfs(board, x, y+1)) return true;     //递归下一个位置
                board[x][y] = '.';      //恢复现场
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
            }
        } 

        return false;       //注意dfs如果有返回值，每一个dfs的地方都需要返回
    }
}
