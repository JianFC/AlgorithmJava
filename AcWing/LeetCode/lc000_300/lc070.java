package AcWing.LeetCode;    //70. 爬楼梯

class Solution {    //DP分析 + 滚动斐波拉契序列
    public int climbStairs(int n) {
        int a = 1, b = 1;   //初始a在第0级台阶，b在第一级台阶
        while (-- n > 0) {
            int c = a + b;  //下一级台阶方案数
            a = b; b = c;   //更新a和b，指向下一级台阶
        }

        return b;
    }
} 
