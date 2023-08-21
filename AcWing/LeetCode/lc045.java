package AcWing.LeetCode;

class Solution {    //DP+单调性优化+分段
    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];   //f[i]代表从起点到i的最小步数

        ////f[i]有单调性，且f[i]每一段的最小步数差值最多为1
        for (int i = 1, j = 0; i < n; i++) {    //定义f[0]=0，不需要计算，j为第一次到达i时上一位置的辅助指针
            while (j + nums[j] < i) j++;    //从前往后找到第一个能跳到i的j
            f[i] = f[j] + 1;    //更新f[i];
        }

        return f[n - 1];
    }
}
