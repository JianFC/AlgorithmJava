package AcWing.LeetCode;

class Solution {    //异或性质考察（交换律，结合律，a ^ a = 0, (00, 11) = 0, (10, 01) = 1）
    public int singleNumber(int[] nums) {
        int res = 0;
        for (var x: nums) res ^= x;     // a ^ a = 0;
        return res;
    }
}
