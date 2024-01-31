package AcWing.LeetCode;        //172. 阶乘后的零

class Solution {    //思维题 + 模板题 + 时O(logn)
    public int trailingZeroes(int n) {
        int res = 0;    //记录n!中质因子5的次数, res = min(2质因子幂，5质因子幂) = 5质因子幂
        while (n > 0) {
            res += n / 5;   //res = n / 5 + n / 5^2 + n / 5^3 ... 
            n /= 5;     
        }

        return res;
    }
}