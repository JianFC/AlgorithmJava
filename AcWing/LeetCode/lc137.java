package AcWing.LeetCode;        //137. 只出现一次的数字 II

class Solution {    //思维题 + DFA(有限状态机) + 位运算
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;   // (two, one) 的每一位表示3个状态，0(00), 1(01)，2(10)
        for (var x: nums) {     // 每一位并行计算
            one = (one ^ x) & ~two; //根据DFA推出公式
            two = (two ^ x) & ~one;
        }

        return one;     //最终答案每一位只可能是0or1，two位一定是0，所以返回one即可
    }
}
