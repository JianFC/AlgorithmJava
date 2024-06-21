package AcWing.LeetCode;        //48. 旋转图像

class Solution {    //思维题
    public void rotate(int[][] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i ++)     //先沿正对角线翻转
            for (int j = 0; j < i; j ++) {
                int t = nums[i][j]; nums[i][j] = nums[j][i]; nums[j][i] = t;
            }
        
        for (int i = 0; i < n; i ++)     //再沿中轴翻转
            for (int j = 0, k = n - 1; j < k; j ++, k --) {   //双指针
                int t = nums[i][j]; nums[i][j] = nums[i][k]; nums[i][k] = t;
            }
    }
}
