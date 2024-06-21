package AcWing.LeetCode;        //198. 打家劫舍

class Solution {    //状态机DP + 时O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][2];  //f[i][0]表示第i家店不选的状态，1表示第i家店选的状态
        f[0][1] = -0x3f3f3f3f;      //初始化f[0][1]状态，f[0][0]默认为0
        for (int i = 1; i <= n; i ++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i - 1];    //注意nums的下标转换
        }

        return Math.max(f[n][0], f[n][1]);  //最后在f[n][1]和f[n][0]中去max
    }
}
