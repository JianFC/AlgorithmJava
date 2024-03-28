package AcWing.SwordOffer;      //88. 树中两个结点的最低公共祖先

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {    //LCA + 模板题
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;      //4. 搜到了叶子节点，没有搜到p or q，返回null
        if (root == p || root == q) return root;    //5. 找到了p或者q节点，直接返回root，此时有两种情况，根据图解分析
        
        var left = lowestCommonAncestor(root.left, p, q);       //1. 递归往左子树搜索p or q
        var right = lowestCommonAncestor(root.right, p, q);     //2. 递归往右子树搜索p or q
        if (left != null && right != null) return root;     //3. 搜索到了p和q处于不同的子树中 
                            //且left和right从下层往上在最早的root相遇，此时root为p和q的LCA
        if (left != null) return left;  //p和q返回的分支在left相遇，left为LCA
        return right;    //题目保证一定有解，所以p和q返回的分支在right相遇，返回right
    }
}