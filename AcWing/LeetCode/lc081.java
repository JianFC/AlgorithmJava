package AcWing.LeetCode;        //81. 搜索旋转排序数组 II

class Solution {    //二分性质理解考察 + 思维题
    public boolean search(int[] nums, int target) {
        int R = nums.length - 1;
        while (R >= 0 && nums[R] == nums[0]) R --;   //去掉第二段末尾与第一段开头的重复元素
                                                    //且由于判断是否存在，不影响结果，最坏O(n)
        if (R < 0) return target == nums[0];    //nums中所有元素一样

        //二分分界点
        int l = 0, r = R;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }

        //判断target在左区间还是右区间
        if (target >= nums[0]) l = 0;   //在左区间
        else {
            l ++; r = R; //在右区间
        }

        //判断target是否存在
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return nums[r] == target;
    }
}
