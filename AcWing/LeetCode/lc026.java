package AcWing.LeetCode;

class Solution {    //单调性+双指针
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1])     //i为0 or nums[i] != nums[i-1]
                nums[k++] = nums[i];
         }

         return k;
    }
}
