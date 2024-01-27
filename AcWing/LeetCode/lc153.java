package AcWing.LeetCode;        //153. 寻找旋转排序数组中的最小值

class Solution {        //二分 + 模板提
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1; //二分左右边界
        if (nums[r] > nums[l]) return nums[0];      //没有进行旋转
        while (l < r) {     //二分右区间中答案
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }

        return nums[l];
    }
}