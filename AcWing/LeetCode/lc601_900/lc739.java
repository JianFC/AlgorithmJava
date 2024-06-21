package AcWing.LeetCode;        //739. 每日温度

class Solution {    //单调栈模板 + 时O(n)
    public int[] dailyTemperatures(int[] t) {
        int N = t.length;
        int[] stk = new int[N + 10]; int tt = 0;     //定义栈，注意栈的容量需要比t的容量大1
        int[] res = new int[N];
        for (int i = t.length - 1; i >= 0; i --) {
            while (tt > 0 && t[i] >= t[stk[tt]]) tt --;      //维护单调栈性质
            if (tt > 0) res[i] = stk[tt] - i;     //更新答案
            stk[++ tt] = i;     //下标i入栈
        }

        return res;     //返回答案
    }
}
