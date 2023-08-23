package AcWing.LeetCode;

class Solution {    //模拟+思维题+等差数列
    public String convert(String s, int n) {
        if (n == 1) return s; //特判，边界情况，防止q=0死循环
        
        //每个字符遍历一次，时间复杂度O(n)
        String res = "";
        int q = 2 * (n - 1);  //公差
        for (int i = 0; i < n; i++) { //对每行分别处理
            if (i == 0 || i == n-1) { //首行和尾行a1 = i, q = 2*(nrows-1)
                for (int j = i; j < s.length(); j += q)
                    res += s.charAt(j);
            }
            else {
                for (int j = i, k = 2 * n - i - 2; j < s.length() || k < s.length(); j += q, k += q) {
                    //第i行(0<i<n-1)，首项分别是a0=i, b0=2*n-i-2，两等差数列交替排列
                    if (j < s.length()) res += s.charAt(j);
                    if (k < s.length()) res += s.charAt(k);
                }
            }
        }

        return res;
    }
}