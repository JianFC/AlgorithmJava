package AcWing.LeetCode;        //11. 盛最多水的容器

class Solution {    //双指针 + 思维题
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {     //双指针算法
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));  //更新结果
            if (height[i] > height[j]) j --;     //当height[i] > height[j]时 j--
            else i ++;   //当h[i] <= h[j]时，i ++，画图理解，最优结果一定会被遍历到
        }

        return res;
    }
}
