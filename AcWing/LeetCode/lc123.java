package AcWing.LeetCode;        ////123. 买卖股票的最佳时机 III

class Solution {    //前后缀分解O(n)  + 思维题 + 模板题
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 1];   //f[i]表示1~i天中交易一次获利的最大值
        for (int i = 1, minp = 0x3f3f3f3f; i <= n; i ++) {  //预处理f[i]
            f[i] = Math.max(f[i - 1], prices[i - 1] - minp);    //递推式
            minp = Math.min(prices[i - 1], minp);   //prices[i-1]为第i天的价格，下标映射
        }

        int res = f[n];     //初始化为第一次交易最大值
        for (int i = n, maxp = 0; i > 0; i --) {    //i枚举第二次交易起始点，从后往前求maxp
            res = Math.max(res, f[i - 1] + maxp - prices[i - 1]);   //i - 1下表映射
            maxp = Math.max(maxp, prices[i - 1]);   //更新maxp
        }

        return res;
    }
}
