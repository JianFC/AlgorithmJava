package AcWing.LeetCode;        //122. 买卖股票的最佳时机 II

class Solution {    //思维题 + 贪心 + 数学拆分
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i + 1 < prices.length; i ++) 
            res += Math.max(0, prices[i + 1] - prices[i]);  //将连续的交易拆分为隔天交易，再用贪心
        
        return res;
    }
}
