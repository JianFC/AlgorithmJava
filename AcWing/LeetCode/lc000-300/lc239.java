package AcWing.LeetCode;        //239. 滑动窗口最大值

class Solution {    //单调队列 + 滑动窗口 + 时O(n)
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;    
        int[] q = new int[n + 10];      //单调队列
        int hh = 0, tt = -1;    //hh表示队头，tt表示队尾

        List<Integer> res = new ArrayList<>();      //记录答案
        for (int i = 0; i < n; i ++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh ++;   //队列中有元素，且队头元素滑出窗口
            while (hh <= tt && a[i] >= a[q[tt]]) tt --;     //维护单调队列性质，每个元素只会出队一次，时O(n)
            q[++ tt] = i;   //a[i]加入单调队列

            if (i - k + 1 >= 0) res.add(a[q[hh]]);  //当窗口内元素有k个时，记录最大值
        }

        //List转数组
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) ans[i] = res.get(i);

        return ans;
    }
}