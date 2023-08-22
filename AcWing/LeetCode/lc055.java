package AcWing.LeetCode;

class Solution {    //思维题+DP分析
    public boolean canJump(int[] nums) {
        //i表示当前扫描到的位置，j表示向后能跳到的最远位置，可跳的位置一定是连续的
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (j < i) return false;    //当前位置i不能跳到，由于可跳到的位置一定是连续的
                                        //所以i及后面的位置都不能跳到，故返回假
            j = Math.max(j, i + nums[i]);   //更新能跳到的最远位置j
        }

        return true;
    }
}
