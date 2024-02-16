package AcWing.LeetCode;        //213. 打家劫舍 II

class Solution {    //状态机DP + 分类计算 + 时O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;   //特判1
        if (n == 1) return nums[0];     //特判2
        int[] f = new int[n + 1], g = new int[n + 1];   //f[i]代表不选第i家店的状态，g[i]代表选择第i家店的状态
        //情况1，不选起点1，从第2家店开始枚举
        for (int i = 2; i <= n; i ++) {
            f[i] = g[i - 1] + nums[i - 1];  //注意nums需要下标映射
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        int res = Math.max(f[n], g[n]);     //第一种情况最大值
        //情况2，选择起点i
        f[1] = nums[0];     //选择起点i
        g[1] = -0x3f3f3f3f;     //设置非法状态g[1]为最小值，防止其更新其他状态
        for (int i = 2; i <= n; i ++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }

        return Math.max(res, g[n]);     //最后三个值取max即为答案
    }
}
