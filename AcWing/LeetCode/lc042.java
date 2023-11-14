package AcWing.LeetCode;        //42. 接雨水

class Solution {    //单调栈 + 模拟
    int N = 100010;
    public int trap(int[] height) {
        int[] stk = new int[N]; int tt = 0;     //单调栈

        int res = 0;
        for (int i = 0; i < height.length; i ++) {
            int last = 0;   //定义单调栈中前一个栈顶元素的高度
                            //访问第一个栈顶元素时，前一个栈顶元素宽度为0，故不会影响结果
            while (tt > 0 && height[stk[tt]] <= height[i]) {    //当栈顶元素高度<=当前高度时
                //不断计算当前栈顶元素与当前柱子形成的矩形的面积
                res += (height[stk[tt]] - last) * (i - stk[tt] - 1);    
                last = height[stk[tt]];     //更新last
                tt --;   //栈顶元素出栈
            }

            //当栈非空时，height[stk[tt]] > height[i]，计算i和最后的栈顶元素的矩形的面积
            if (tt > 0) res += (i - stk[tt] - 1) * (height[i] - last);
            stk[++ tt] = i;  //当前柱子下标进栈
        }

        return res;
    }
}