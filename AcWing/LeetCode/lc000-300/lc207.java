package AcWing.LeetCode;

class Solution {    //拓扑排序 + 模板题 + 时O(m)
    int N = 2010, M = 5010;     //n表示节点数，m表示边数
    int[] h = new int[N], e = new int[M], ne = new int[M];      //邻接表存图
    int idx = 0;
    int[] d = new int[N];   //存储每个节点的入度
    Queue<Integer> q = new LinkedList<>();

    void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx ++;  //邻接表存边
    }

    public boolean canFinish(int n, int[][] edges) {
        Arrays.fill(h, -1);     //初始化邻接表数组
        for (int i = 0; i < edges.length; i ++) {
            int b = edges[i][0], a = edges[i][1];   
            add(a, b);  //建有相图
            d[b] ++;    //更新b节点的入度
        }

        int cnt = 0;    //记录所有能修的课程数量
        for (int i = 0; i < n; i ++)
            if (d[i] == 0) q.offer(i);  //所有入度为0的节点入队
        
        while (q.size() > 0) {
            int t = q.poll();   //取队头
            cnt ++;     //更新能修的课程数量
            for (int i = h[t]; i != -1; i = ne[i]) {    //遍历t的所有边
                int j = e[i];   //取出相邻节点
                if (-- d[j] == 0) q.offer(j);   //更新邻接点入度和队列
            }
        }

        return cnt == n;    //判断能修的数量是否为n
    }
}
