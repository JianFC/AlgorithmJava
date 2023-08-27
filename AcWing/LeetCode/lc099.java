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
class Solution {    //BST的Morris中序遍历算法+逆序对+思维题
    public void recoverTree(TreeNode root) {
        //first记录第一个需要交换的点，second存储第二个需要交换的点
        //last为该点中序遍历的上一个点，用于寻找逆序对
        TreeNode first = null, second = null, last = null;
        while (root != null) {
            if (root.left == null) {    //没有左子树，则直接遍历该店，走到右子树
                if (last != null && last.val > root.val) {  //找到逆序对
                    if (first == null) {
                        first = last; second = root;    //第一种情况，更新逆序对的第一个和第二个数
                    }
                    else second = root;     //第二种情况，更新second指针，存储需要换的第二个节点
                }
                last = root;    //更新last
                root = root.right;  //走到右儿子   
            }
            else {
                var p = root.left;  //找到root的前驱节点p
                while (p.right != null && p.right != root) p = p.right;    //一直往右走到底
                if (p.right == null) {
                    p.right = root; //从上往下，p.right = root;
                    root = root.left; //更新root，处理左子树
                }
                else {
                    p.right = null; //下往上，清空p.right，保证树结构
                    if (last != null && last.val > root.val) {  //找到逆序对
                        if (first == null) {
                            first = last; second = root;
                        }
                        else second = root;
                    }
                    last = root;    //更新last
                    root = root.right;  //更新root
                }
            }
        }

        int t = first.val; first.val = second.val; second.val = t;  //交换
    }
}
