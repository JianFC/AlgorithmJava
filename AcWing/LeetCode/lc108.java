package AcWing.LeetCode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {    //递归+线段树与平衡树建树方式
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null; //区间已空
        int mid = l + r >> 1;   //求出中点
        var root = new TreeNode(nums[mid]); //创建root
        root.left = build(nums, l, mid - 1);  //创建左子树
        root.right = build(nums, mid + 1, r); //创建右子树
        return root;
    }
}
