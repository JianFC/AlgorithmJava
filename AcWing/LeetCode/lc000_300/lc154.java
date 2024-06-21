package AcWing.LeetCode;        //154. 寻找旋转排序数组中的最小值 II

class Solution {    //二分 + 模板题 + 时最坏O(n)
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;     //定义区间左右端点
        while (l < r && nums[r] == nums[0]) r --;   //将末尾和开头相同的数删掉，以进行二分
        if (nums[l] < nums[r]) return nums[0];  //序列单调不降
        while (l < r) {     //二分右区间答案
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }

        return nums[l];
    }
}