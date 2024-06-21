package AcWing.LeetCode;        //188. 买卖股票的最佳时机 IV

class Solution {    //状态机模型DP + 股票模型模板题
    public int maxProfit(int k, int[] w) {
        int n = w.length, INF = 0x3f3f3f3f;
        int[][][] f = new int[n + 1][k + 1][2]; //f[i][j][0]表示前i天，完成了j次交易，手中无货状态，受益最大值
            //f[i][j][1]表示前i天，正在进行第j次交易，手中有货状态，可进一步用滚动数组优化一维
        for (int i = 0; i < n + 1; i ++)
            for (int j = 0; j <= k; j ++) Arrays.fill(f[i][j], -INF);    //初始化f数组
        for (int i = 0; i < n + 1; i ++) f[i][0][0] = 0;    //初始化边界，一直不买入

        for (int i = 1; i < n + 1; i ++)    //枚举天数
            for (int j = 1; j <= k; j ++) {     //枚举交易次数
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + w[i - 1]);   //手中无货计算方式，注意w的下标转换
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - w[i - 1]);    //手中有货计算方式
            }
        
        int res = 0;    //存储最终答案
        for (int i = 0; i <= k; i ++) res = Math.max(f[n][i][0], res);      //枚举手中前n无货状态的交易次数，找出答案
        return res;
    }
}