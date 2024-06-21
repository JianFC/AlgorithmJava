package AcWing.LeetCode;        //80. 删除有序数组中的重复项 II

class Solution {    //双指针 + 单调性 + 思维题
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (var num: nums) {
            //当k小于2时都加入，且由于[0, k - 1]为有序，且nums有序，所以只需看k - 1, k - 2两个
            //位置上的数是否为num就可以确定num在[0, k - 1]中是否已经出现了两次
            if (k < 2 || (nums[k - 1] != num || nums[k - 2] != num))
                nums[k ++] = num;
        }

        return k;
    }
}