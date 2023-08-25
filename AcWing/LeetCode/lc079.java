package AcWing.LeetCode;

class Solution {    //DFS+路径搜索+剪枝+方向向量
    public boolean exist(char[][] boa, String wd) {
        for (int i = 0; i < boa.length; i++)
            for (int j = 0; j < boa[0].length; j++)
                //从每个点开始搜
                if (dfs(boa, wd, 0, i, j)) return true;
        
        return false;
    }

    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};   //移动的方向向量
    //u表示当前搜到了wd的第几个字符，(x, y)表示boa的坐标
    boolean dfs(char[][] boa, String wd, int u, int x, int y) {
        if (boa[x][y] != wd.charAt(u)) return false;
        if (u == wd.length() - 1) return true;  //搜到word

        char t = boa[x][y];
        boa[x][y] = '.';    //当前位置已经搜过，标记
        for (int i = 0; i < 4; i++) {   //枚举方向向量
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= boa.length || b < 0 || b >= boa[0].length || boa[a][b] == '.')
                continue;   //不合法位置
            //不能写成return dfs(boa, wd, u + 1, a, b);
            if (dfs(boa, wd, u + 1, a, b)) return true; 
        }
        boa[x][y] = t;  //恢复现场
        return false;   //没有搜到，返回false
    }           
}
