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

class Solution {    //BFS+链表维护+思维题
    public Node connect(Node root) {
        if (root == null) return root;
        var cur = root;
        while (cur != null) {   //cur指向每一层从左往右第一个点
            var head = new Node(-1);    //手动维护下一层链表，虚拟头节点
            var tail = head;    //下一层链表尾节点
            for (var p = cur; p != null; p = p.next) {  //层序遍历，手动维护链表
                if (p.left != null) tail = tail.next = p.left;
                if (p.right != null) tail = tail.next = p.right;
            }
            cur = head.next;    //更新cur为下一层链表头节点
        }

        return root;        
    }
}
