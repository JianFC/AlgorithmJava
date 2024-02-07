package AcWing.LeetCode;        //190. 颠倒二进制位

public class Solution {     //位运算 + 时O(1)
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++)   //分别取出每一位
            res = (res << 1) + (n >> i & 1);      //位运算，注意优先级
        return res;
    }
}
