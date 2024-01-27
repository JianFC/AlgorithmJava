package AcWing.LeetCode;        //152. 乘积最大子数组

class Solution {        //线性DP + 思维题 + 滚动数组优化 + 时O(N)空O(1)
    public int maxProduct(int[] nums) {
        int res = nums[0];     //存储最终结果，初始化为第一个数
        int f = nums[0], g = nums[0];       //f和g：滚动数组优化后存储最大值和最小值
        for (int i = 1; i < nums.length; i ++) {    //注意从第二个数开始
            int a = nums[i], fa = f * a, ga = g * a;
            f = Math.max(a, Math.max(fa, ga));      //递推求出右端点为i的子数组乘积最大值
            g = Math.min(a, Math.min(fa, ga));      //递推求出右端点为i的子数组乘积最小值
            res = Math.max(res, f);     //更新最终结果
        }

        return res;
    }
}
