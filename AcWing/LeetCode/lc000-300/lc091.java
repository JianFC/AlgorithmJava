package AcWing.LeetCode;        //91. 解码方法

class Solution {    //线性DP + 思维题 + 爬楼梯
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;    //下标从1开始
        int[] f = new int[n + 1];   //f[i]表示所有前i个数字映射回去的方案数量
        f[0] = 1;   //初始化
        for (int i = 1; i <= n; i ++) {
            if (s.charAt(i) >= '1' && s.charAt(i) <= '9') f[i] += f[i - 1];
            if (i > 1) {
                //计算前两个数字组成的数是多少
                int t = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
                if (t >= 10 && t <= 26) f[i] += f[i - 2];
            }
        }

        return f[n];
    }
}