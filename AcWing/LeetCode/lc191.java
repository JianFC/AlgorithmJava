package AcWing.LeetCode;    //191. 位1的个数

public class Solution {     //lowbit函数 + 位运算 + 时O(1)
    // you need to treat n as an unsigned value
    int lowbit(int x) {
        return x & -x;
    }

    public int hammingWeight(int n) {
        int cnt = 0;    //记录1的个数
        while (n != 0) {
            n -= lowbit(n); cnt ++;
        }

        return cnt;
    }
}
