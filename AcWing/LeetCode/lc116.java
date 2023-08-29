package AcWing.LeetCode;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {    //BFS+next优化
    public Node connect(Node root) {
        if (root == null) return root;
        var source = root;  //记录根节点
        while (root.left != null) {     //root表示每一层从左往右第一个点
            for (var p = root; p != null; p = p.next) {    //层序遍历，从root开始
                p.left.next = p.right;  //左儿子的next = 右儿子
                if (p.next != null) p.right.next = p.next.left;
            }
            root = root.left;   //更新root
        }

        return source;
    }
}
