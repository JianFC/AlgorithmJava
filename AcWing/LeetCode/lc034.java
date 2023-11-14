package AcWing.LeetCode;        //34. 在排序数组中查找元素的第一个和最后一个位置

class Solution {    //二分
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) return res;   //判空
        
        int l = 0, r = nums.length - 1;
        while (l < r) {     //二分右区间，找左端点
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid+1;
        }

        if (nums[l] != target) return res;
        else res[0] = l;

        l = 0; r = nums.length - 1;
        while (l < r) {     //二分左区间，找右端点
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        res[1] = l;

        return res;
    }
}