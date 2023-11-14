package AcWing.LeetCode;        //36. 有效的数独

class Solution {    //模拟题
    public boolean isValidSudoku(char[][] board) {
        boolean[] st = new boolean[9];  //存储1-9是否已经出现，true出现过

        //判断行
        for (int i = 0; i < 9; i ++) {
            Arrays.fill(st, false);     //每行初始时清空st数组
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }
        
        //判断列
        for (int i = 0; i < 9; i ++) {
            Arrays.fill(st, false);     //每行初始时清空st数组
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] != '.') {
                    int t = board[j][i] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }

        //判断3*3九宫格
        for (int i = 0; i < 9; i += 3) 
            for (int j = 0; j < 9; j += 3) {    //枚举起点坐标
                Arrays.fill(st, false);
                for (int x = 0; x < 3; x ++)     //枚举便宜
                    for (int y = 0; y < 3; y ++) {
                        if (board[i + x][j + y] != '.') {
                            int t = board[i + x][j + y] - '1';
                            if (st[t]) return false;
                            st[t] = true;
                        }
                    }
            }

        return true;
    }
}
