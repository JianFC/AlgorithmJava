package AcWing.LeetCode;    //209. 长度最小的子数组

class Solution {    //单调性 + 双指针 + 时O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int res = 0x3f3f3f3f;    //定义答案
        for (int i = 0, j = 0, sum = 0; i < nums.length; i ++) {    //枚举区间右端点，j为满足区间和≥s的最右点
            sum += nums[i];     //sum维护[j, i]的区间和
            while (sum - nums[j] >= s) sum -= nums[j ++];   //试探法，对于每一个i，找到满足条件的最靠右j点，j存在单调性
            if (sum >= s) res = Math.min(res, i - j + 1);   //更新最小区间长度
        }

        if (res == 0x3f3f3f3f) res = 0;     //不存在答案
        return res;
    }
}
