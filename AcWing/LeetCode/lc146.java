package AcWing.LeetCode;        //146. LRU 缓存

class LRUCache {    //struct定义双链表 + 哈希表 + 思维题
    class Node {    //定义双链表节点
        int key, val;
        Node left, right;
        Node (int _key, int _val) {
            key = _key; val = _val;
        }
    }
    
    Node L = new Node(-1, -1), R = new Node(-1, -1);    //头节点和尾节点
    int n;
    Map<Integer, Node> hash = new HashMap<>();  //哈希表，O(1)实现put和get方法

    public LRUCache(int capacity) {
        n = capacity;   //更新容量
        L.right = R; R.left = L;    //初始化头尾节点
    }

    void insert(Node p) {   //将p插到头节点之后
        p.right = L.right; p.left = L;
        L.right.left = p; L.right = p;
    }

    void remove(Node p) {   //删除p节点
        p.left.right = p.right;
        p.right.left = p.left;
    }
    
    public int get(int key) {
        if (!hash.containsKey(key)) return -1;
        var p = hash.get(key);
        remove(p);  //从双链表中移除节点
        insert(p);  //将节点插入双链表头部
        return p.val;
    }
    
    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            var p = hash.get(key);
            p.val = value;  //更新节点的值
            remove(p);
            insert(p);
        }
        else {
            if (hash.size() == n) {
                var p = R.left;     //删除链表尾节点
                remove(p);  //链表中删除
                hash.remove(p.key); //哈希表中删除
            }
            var p = new Node(key, value);   //新建结点
            hash.put(key, p);   //加入hash表
            insert(p);  //插入链表头部
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
