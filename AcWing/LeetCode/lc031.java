package AcWing.LeetCode;

class Solution {    //思维题，单指针
    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;  //从后往前找到第一个正序的位置
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k == 0) reverse(nums, 0, nums.length - 1);
        else {
            int t = k;  //从k的位置往后找到大于k-1位置且最小的数，不能等于
            while (t < nums.length && nums[t] > nums[k - 1]) t++;    //t-1为所求位置
            int tmp = nums[t - 1]; nums[t - 1] = nums[k - 1]; nums[k - 1] = tmp;    //swap(nums[t-1], nums[k-1]);
            reverse(nums, k, nums.length-1);    //将k-1后的位置的逆序排列改为升序排列
        }
    }

    void reverse(int[] nums, int l, int r) {    //翻转从nums中[l, r]的数
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++; r--;
        }
    }
}
