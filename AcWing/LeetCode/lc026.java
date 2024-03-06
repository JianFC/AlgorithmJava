package AcWing.LeetCode;        //26. 删除有序数组中的重复项

class Solution {    //单调性 + 双指针
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0 || nums[i] != nums[i - 1])     //i为0 or nums[i] != nums[i - 1]
                nums[k ++] = nums[i];
         }

         return k;
    }
}
