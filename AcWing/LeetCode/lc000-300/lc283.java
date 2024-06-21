package AcWing.LeetCode;    //283. 移动零

class Solution {    //双指针 + 时O(n)
    public void moveZeroes(int[] nums) {
        int k = 0;  //另一个指针记录当前有效数字的下一个位置
        for (int num : nums) 
            if (num != 0) nums[k ++] = num;     //记录所有有效数字
        
        while (k < nums.length) nums[k ++] = 0;     //最后所有位置补0      
    }   
}
