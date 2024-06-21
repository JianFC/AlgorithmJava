package AcWing.LeetCode;        //994. 腐烂的橘子

class Solution {    //多源BFS + 方向向量 + 时O(nm)
    public int orangesRotting(int[][] g) {
        int n = g.length, m = g[0].length;      //记录矩阵大小
        Queue<PII> q = new LinkedList<>();      //BFS队列
        for (int i = 0; i < n; i ++)        //多源BFS，初始时将所有腐烂的橘子加入队列
            for (int j = 0; j < m; j ++)
                if (g[i][j] == 2) q.offer(new PII(i, j));   

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        int res = 0;    //记录最终的答案，注意是最后一层到第一层的距离，因此需要 - 1
        if (q.size() > 0) res --;   //先将res - 1
        while (q.size() > 0) {      //当队列中还有元素
            res ++;     //新增一层
            int sz = q.size();      //处理该层的每一个元素
            while (sz -- > 0) {    
                PII t = q.poll();   //取出队头并弹出
                for (int i = 0; i < 4; i ++) {
                    int x = t.x + dx[i], y = t.y + dy[i];
                    if (x < 0 || x >= n || y < 0 || y >= m || g[x][y] != 1) continue;   //跳过不合法的位置
                    g[x][y] = 2;    //该橘子腐烂掉
                    q.offer(new PII(x, y));     //将该点压入队列
                }
            }
        }

        //检查是否有新鲜橘子
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                if (g[i][j] == 1) return -1;    //无解
        
        return res;         //返回答案
    }

    class PII {     //记录点的坐标
        int x, y;
        PII (int _x, int _y) {
            x = _x; y = _y;
        }
    }
}
