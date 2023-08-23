package AcWing.LeetCode;

class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //控制res不越界
            if (x > 0 && res > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if (x < 0 && res < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            res = res * 10 + x % 10;      //注意负数的取模运算仍为负数
            x /= 10;
        }

        return res;
    }
}
