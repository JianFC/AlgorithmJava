package AcWing.LeetCode;        //121. 买卖股票的最佳时机

class Solution {    //模拟 + 思维题
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0, minp = 0x3f3f3f3f; i < prices.length; i ++) {
            res = Math.max(res, prices[i] - minp);  //更新第i天卖出时res
            minp = Math.min(minp, prices[i]);   //动态维护1 ~ i - 1中股票价格最小值
        }

        return res;
    }
}
