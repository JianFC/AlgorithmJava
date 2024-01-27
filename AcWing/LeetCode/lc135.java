package AcWing.LeetCode;        //135. 分发糖果

class Solution {    //记忆化搜索 + 滑雪变形
    int N = 100010;
    
    int[] f = new int[N];   //f[i]表示第i个点向左or向右最远可以走几步
    int[] w = new int[N]; 
    int n;

    public int candy(int[] ratings) {
        n = ratings.length;
        w = ratings;
        Arrays.fill(f, -1);     //初始化记忆化搜索数组
        

        int res = 0;
        for (int i = 0; i < n; i ++) res += dp(i);
        return res;
    }

    int dp(int i) {     //记忆化搜索，时间复杂度O(n)
        if (f[i] != -1) return f[i];    //已经搜索过
        f[i] = 1;   //初始化
        if (i > 0 && w[i - 1] < w[i]) f[i] = Math.max(f[i], dp(i - 1) + 1);  //左边孩子更矮
        if (i + 1 < n && w[i + 1] < w[i]) f[i] = Math.max(f[i], dp(i + 1) + 1);  //右边孩子更矮
        return f[i];
    }
}
