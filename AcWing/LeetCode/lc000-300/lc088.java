package AcWing.LeetCode;        //88. 合并两个有序数组

class Solution {    //反向双指针 + 二路归并 + 思维题
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m - 1;  //从后往前存储，不开额外空间且可避免覆盖
        int i  = m - 1, j = n - 1;  //二路归并，从后往前做，每次找最大
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) nums1[k --] = nums1[i --];
            else nums1[k --] = nums2[j --];
        }

        //只用处理nums2，若i >= 0，则nums1中每个元素已在正确位置上
        while (j >= 0) nums1[k --] = nums2[j --]; 
    }
}
