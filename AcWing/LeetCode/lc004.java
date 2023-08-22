package AcWing.LeetCode;

class Solution {    //二分+递归
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        if (tot%2 == 0) {   //偶数个数
            int left = find(nums1, 0, nums2, 0, tot/2);
            int right = find(nums1, 0, nums2, 0, tot/2+1);
            return (left + right) / 2.0;    //除以2.0防止取整
        }
        else return find(nums1, 0, nums2, 0, tot / 2 + 1);  //奇数个数
    }

    //寻找两个正序数组中第k大的元素，k从1开始
    public int find(int[] nums1, int i, int[] nums2, int j, int k) {
          //假设短的数组在前
        if (nums1.length - i > nums2.length - j) return find(nums2, j, nums1, i, k);
        if (nums1.length == i) return nums2[ j + k - 1];  //第一个数组已经处理完毕
        if (k == 1) return Math.min(nums1[i], nums2[j]); //返回两个数组中较小的元素
        
        //si, sj为两个数组二分点下一个点，注意si可能越界
        int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
        if (nums1[si - 1] > nums2[sj - 1])
            return find(nums1, i, nums2, sj, k - (sj - j));
        else 
            return find(nums1, si, nums2, j, k - (si - i));   

    }
}