package AcWing.LeetCode;        //27. 移除元素

class Solution {    //双指针
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++) 
            if (nums[i] != val) nums[k ++] = nums[i];

        return k;
    }
}
