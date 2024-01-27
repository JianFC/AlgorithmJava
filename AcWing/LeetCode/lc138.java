package AcWing.LeetCode;        //138. 随机链表的复制

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {    //时间复杂度O(n), 空间复杂度O(1), + 哈希表优化空间 + 思维题
    public Node copyRandomList(Node head) {
        for (var p = head; p != null; p = p.next.next) {    //为每个节点复制一个小弟挂在next上，所以跳俩次
            var q = new Node(p.val);
            q.next = p.next;    //更新q的next
            p.next = q; //更新p的next
        }

        for (var p = head; p != null; p = p.next.next)     //复制每个节点的random指针，注意跳两次
            if (p.random != null) 
                p.next.random = p.random.next;  //复制random
        
        //把复制的节点拆出来
        var dummy = new Node(-1); var cur = dummy;  //虚拟头节点和尾节点
        for (var p = head; p != null; p = p.next) {
            cur = cur.next = p.next;    //更新cur，拆复制的子节点
            p.next = p.next.next;   //恢复原链表
        }

        return dummy.next;  //返回头节点
    }
}
