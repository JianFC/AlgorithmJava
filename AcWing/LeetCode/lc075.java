package AcWing.LeetCode;        //75. 颜色分类

class Solution {    //思维题 + 模拟 + 指针
    public void sortColors(int[] nums) {
        //[0, j - 1] = 0, [j, i - 1] = 1, [k + 1, n - 1] = 2
        for (int i = 0, j = 0, k = nums.length - 1; i <= k; ) {
            if (nums[i] == 0) {
                int t = nums[j]; nums[j] = nums[i]; nums[i] = t;
                j ++; i ++;   //i,j指针分别向前移动一位
            }
            else if (nums[i] == 2) {
                int t = nums[k]; nums[k] = nums[i]; nums[i] = t;
                k --;    //注意i不用自增
            }
            else if (nums[i] == 1) i ++; //i指针向前移动一位
        }
    }
}
