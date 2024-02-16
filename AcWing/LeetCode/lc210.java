package AcWing.LeetCode;        //210. 课程表 II

class Solution {    //拓扑排序 + 时O(n ^ 2)
    int N = 2010;   //稠密图，通过邻接矩阵进行存储
    int[][] g = new int[N][N];
    Queue<Integer> q = new LinkedList<>();      //拓扑排序队列
    int[] d = new int[N];   //每个节点的入度

    public int[] findOrder(int n, int[][] edges) {
        for (int i = 0; i < edges.length; i ++) {
            int b = edges[i][0], a = edges[i][1];   //取出边的节点
            g[a][b] = 1;    //a->b建边
            d[b] ++;    //更新b节点入度
        }

        for (int i = 0; i < n; i ++)   //遍历所有节点
            if (d[i] == 0) q.offer(i);      //所有入度为0的点入队
        
        List<Integer> res = new ArrayList<>();  //存储拓扑排序结果
        while (q.size() > 0) {
            int t = q.poll();  //取队头并出队
            res.add(t);     //加入答案
            for (int i = 0; i < n; i ++)    //遍历t的所有临边
                if (g[t][i] == 1)
                    if (-- d[i] == 0) q.offer(i);   //更新队列                
        }

        //返回答案
        if (res.size() == n) return res.stream().mapToInt(i -> i).toArray();
        else return new int[]{};
    }
}
