package AcWing.LeetCode;        //84. 柱状图中最大的矩形

class Solution {    //单调栈应用 + 模板题 + 枚举上边界
    public int largestRectangleArea(int[] h) {  
        int n = h.length;
        //left[i]表示第i个数左边第一个比它小的数的下标, right[i]标配是第i个数右边第一个...
        int[] left = new int[n], right = new int[n]; 
        int[] stk = new int[n + 1]; int tt = 0;     //存储下标的单调栈

        //求出每个数左边第一个比它小的数的下标，更新left数组，从左往右扫描, O(n)
        for (int i = 0; i < n; i ++) {
            while (tt > 0 && h[stk[tt]] >= h[i]) tt --;  //找到第一个≤的数的下标
            if (tt == 0) left[i] = -1;  //i左边所有数>=i
            else left[i] = stk[tt]; //更新left[i]``
            stk[++ tt] = i;  //将第i个数加入单调栈，维护单调栈性质
        }

        tt = 0;     //清空单调栈

        //求出每个数右边第一个比它小的数的下标，更新right数组，从左往右扫描, O(n)``
        for (int i = n - 1; i >= 0; i --) {
            while (tt > 0 && h[stk[tt]] >= h[i]) tt --;
            if (tt == 0) right[i] = n;  //i右边所有数>=i
            else right[i] = stk[tt];
            stk[++ tt] = i;
        }

        int res = 0;    //存储答案，枚举每一个矩形的上边界
        for (int i = 0; i < n; i ++) res = Math.max(res, h[i] * (right[i] - left[i] - 1));

        return res;
    }
}