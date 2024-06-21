package AcWing.LeetCode;        //173. 二叉搜索树迭代器

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
class BSTIterator {     //二叉树中序遍历 + 模板题 + 分拆
    Stack<TreeNode> stk = new Stack<>();    //定义中序遍历的辅助栈

    public BSTIterator(TreeNode root) {     //将中序遍历迭代写法分拆成三个函数，初始将root左链入栈
        while (root != null) {       //初始将root左链入栈
            stk.push(root);    
            root = root.left;
        }
    }
    
    public int next() {     //均摊时间复杂度O(1)，空间O(h)
        var root = stk.pop();    //取出下一个节点
        int val = root.val;
        root = root.right;      //走到该节点的右儿子
        while (root != null) {  //将右儿子的左链入栈
            stk.push(root);     //每个节点只会入栈一次，出栈一次，均摊时间复杂度O(1)
            root = root.left;
        }
        return val;     //返回遍历的值
    }
    
    public boolean hasNext() {
        return stk.size() > 0;      //判断是否有下一个元素
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
