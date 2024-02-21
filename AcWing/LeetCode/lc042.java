package AcWing.LeetCode;        //42. 接雨水

class Solution {    //单调栈 + 模拟
    int N = 100010;
    public int trap(int[] h) {
        int[] stk = new int[N]; int tt = 0;     //单调栈

        int res = 0;
        for (int i = 0; i < h.length; i ++) {
            int last = 0;   //定义单调栈中 前一个栈顶元素 的高度
                            //访问第一个栈顶元素时，前一个栈顶元素宽度为0，故不会影响结果
            while (tt > 0 && h[stk[tt]] <= h[i]) {    //当栈顶元素高度 <= 当前高度时
                //不断计算当前栈顶元素与当前柱子形成的矩形的面积，last表示当前栈顶上一个栈顶元素的值
                //(h[stk[tt]] - last)表示当前栈顶和上一个栈顶的高度差，(i - stk[tt] - 1)表示当前栈顶和当前柱子间的宽度
                res += (h[stk[tt]] - last) * (i - stk[tt] - 1);    
                last = h[stk[tt]];     //更新上一个栈顶元素高度last
                tt --;   //栈顶元素出栈
            }

            //当栈非空时，h[stk[tt]] > h[i]，计算i和最后的栈顶元素的矩形的面积
            if (tt > 0) res += (i - stk[tt] - 1) * (h[i] - last);
            stk[++ tt] = i;  //当前柱子下标进栈
        }

        return res;
    }
}