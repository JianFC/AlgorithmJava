package AcWing.LeetCode;        //215. 数组中的第K个最大元素

class Solution {    //快速选择算法 + 快排模板 + 时O(n)
    int quick_sort(int[] nums, int l, int r, int k) {   //快速选择算法
        if (l >= r) return nums[l];
        
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i ++; while (nums[i] > x);   //注意是第k大数，需要把数组倒序排序
            do j --; while (nums[j] < x);
            if (i < j) {
                int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
            }
        }

        if (k > j) return quick_sort(nums, j + 1, r, k);    //第二种实现思路，和j下标比较，第k大数在右侧
        else return quick_sort(nums, l, j, k);  //第k大数在左侧
    }

    public int findKthLargest(int[] nums, int k) {
        return quick_sort(nums, 0, nums.length - 1, k - 1);     //注意数组下标从0开始
    }
}
