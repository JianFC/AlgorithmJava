package AcWing.LeetCode;        //189. 轮转数组

class Solution {   //思维题 + 模板题 + 时O(n) + 空O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;     //将k映射到数组长度范围内
        reverse(nums, 0, n - 1);    //数组整体翻转
        reverse(nums, 0, k - 1);    //将nums[0, k - 1]进行翻转
        reverse(nums, k, n - 1);    //将nums[k, n - 1]进行翻转
    }

    void reverse(int[] nums, int l, int r) {    //将数组nums[l, r]进行翻转
        while (l < r) {
            int c = nums[l]; nums[l] = nums[r]; nums[r] = c;
            l ++; r --;
        }
    }
}
