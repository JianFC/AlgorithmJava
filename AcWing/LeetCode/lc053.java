package AcWing.LeetCode;        //53. 最大子数组和

class Solution {    //线性DP + DP数组优化
    public int maxSubArray(int[] nums) {
        int res = -0x3f3f3f3f; 
        //f[i]表示所有以i结尾的子串的集合，属性为和的最大值
        for (int i = 0, last = 0; i < nums.length; i ++) {
            last = nums[i] + Math.max(0, last);     //f[i] = max(nums[i], f[i - 1] + nums[i])
            res = Math.max(last, res);
        }

        return res;
    }
}

//TODO：分治做法，类线段树
