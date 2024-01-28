package AcWing.LeetCode;    //162. 寻找峰值

class Solution {    //二分 + 思维题 + 模板题
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;     //二分左右边界
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;     //峰值在包含mid的左区间中，此处不会越界，
            //因为mid是下取整，当mid = length - 1时，l = r = length - 1，不会进入循环，该情况不会发生
            else l = mid + 1;   //峰值在不包含mid的右区间中
        }

        return l;
    }
}
