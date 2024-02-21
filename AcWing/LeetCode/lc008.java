package AcWing.LeetCode;        //8. 字符串转换整数 (atoi)

class Solution {    //模拟 + 边界判断 + 思维
    public int myAtoi(String s) {
        int k = 0;  //遍历s
        while (k < s.length() && s.charAt(k) == ' ') k ++;   //去掉前导空格
        if (k == s.length()) return 0;  //特判

        int sig = 1;    //默认为正数
        if (s.charAt(k) == '-') {   //处理正负
            sig = -1; k ++;
        }
        else if (s.charAt(k) == '+') k ++;   //注意else

        int res = 0;
        while (k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9') {
            int x = s.charAt(k) - '0';
            if (sig > 0 && res > (Integer.MAX_VALUE - x) / 10) return Integer.MAX_VALUE;
            if (sig < 0 && -res < (Integer.MIN_VALUE + x) / 10 ) return Integer.MIN_VALUE;
            //abs(Interger.MIN_VALUE) 比MAX_VALUE大一
            if (-res * 10 - x == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            res = res * 10 + x;
            k ++;
        }

        return res * sig;
    }
}