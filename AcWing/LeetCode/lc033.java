package AcWing.LeetCode;

class Solution {    //二分
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l < r) {     //第一次二分找出旋转点，二分左区间中答案
            int mid = l+r+1>>1;     //+1防止死循环
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid-1;
        }

        if (target >= nums[0]) l = 0;   //target在左区间中，r不用变
        else {
            l = r+1; r = nums.length-1; //target在右区间中，更新l和r
        }

        while (l < r) {     //第二次二分找target
            int mid = l+r>>1;
            if (nums[mid] >= target) r = mid;
            else l = mid+1;
        }

        if (nums[r] == target) return r;    
        else return -1;
    }
}