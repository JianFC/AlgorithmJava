package AcWing.LeetCode;

class Solution {    //贪心 + 递推 + 思维题
    public int scheduleCourse(int[][] cs) {
        int n = cs.length;
        Arrays.sort(cs, 0, n, (o1, o2) -> o1[1] - o2[1]);   //将cs数组按照ddl从小到大排序
        //用大根堆来维护所选的课程，便于找最大值
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int tot = 0;    //记录总上课时间
        for (int i = 0; i < n; i ++) {
            tot += cs[i][0];    //首先将当前课程用时加入，如果能完成f[i] = f[i - 1] + 1
            heap.offer(cs[i][0]);   
            if (tot > cs[i][1])    //不能完成，f[i] = f[i - 1]，踢掉用时最大值
                tot -= heap.poll();     //更新tot，踢掉最大值
        }

        return heap.size();
    }
}
