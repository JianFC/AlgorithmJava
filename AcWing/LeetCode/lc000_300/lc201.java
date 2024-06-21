package AcWing.LeetCode;        //201. 数字范围按位与

class Solution {    //思维题 + 位运算 + 时O(1)
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for (int i = 30; i >= 0; i --)      //n最大为2^31 - 1，故n有31位
            if ((m >> i & 1) != (n >> i & 1)) break;    //取出所有相同的位
            else if ((m >> i & 1) == 1) res += (1 << i);    //加上所有相同的为1的前缀
        return res;
    }
}
