package AcWing.LeetCode;

class Solution {    //Flood Fill算法 + DFS实现 + 方向向量 + 时O(n)
    char[][] g;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};    //方向向量

    public int numIslands(char[][] grid) {
        g = grid;   //将grid置为全局变量
        int cnt = 0;    //连通块数量
        for (int i = 0; i < g.length; i ++)
            for (int j = 0; j < g[i].length; j ++)
                if (grid[i][j] == '1') {
                    dfs(i, j);      //找到一个新的连通块
                    cnt ++;     //连通块数量增加
                }
        return cnt;
    }

    void dfs(int x, int y) {
        g[x][y] = '0';  //更新地图，防止重复遍历，行使st数组功能
        for (int i = 0; i < dy.length; i ++) {
            int a = x + dx[i], b = y + dy[i];   //新位置
            if (a >= 0 && a < g.length && b >= 0 && b < g[a].length && g[a][b] == '1')  //合法性检查
                dfs(a, b);  //继续搜索该连通块
        }
    }
}
