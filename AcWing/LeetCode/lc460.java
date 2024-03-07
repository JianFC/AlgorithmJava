package AcWing.LeetCode;

class LFUCache {    //双链表LFU套双链表LRU + 模拟题 + 数据结构
    class Node {        //每个block内部节点，LRU双链表
        int key, val;     
        Node left, right;
        Node (int _key, int _val) {
            key = _key; val = _val;
            //left, right自动为null
        }
    }

    class Block {   //外部Block块，维护使用次数的双链表，内部为Node双链表
        int cnt;    //该块所代表的使用次数
        Node head, tail;  //维护内部双链表的头尾哨兵节点
        Block left, right;  //该block的前一个和后一个块
        Block (int _cnt) {
            cnt = _cnt;     //该块所代表的使用次数
            head = new Node(-1, -1); tail = new Node(-1, -1);   //维护内部的双链表结构
            head.right = tail; tail.left = head;   //维护头尾烧饼关系
            //left, right自动为null
        }

        public void insert(Node p) {    //在该块内新加入一个节点，插入到头部
            p.right = head.right;
            head.right.left = p;
            head.right = p;
            p.left = head;
        }

        public void remove(Node p) {    //在该块内移除一个节点
            p.left.right = p.right;
            p.right.left = p.left;
        }

        public boolean empty() {        //判断该块是否为空
            return head.right == tail;      
        }
    }
    
    Block bhead, btail;   //外层LFU块的头尾哨兵节点
    Map<Integer, Node> hash_node = new HashMap<>();     //block内key -> node的哈希表
    Map<Integer, Block> hash_block = new HashMap<>();    //LFU中key -> blcok的哈希表
    int capacity;       //LFU缓存节点容量

    void insert(Block p) {   //在p块后新插入一个块，cnt = p.cnt + 1;
        Block q = new Block(p.cnt + 1);     //当目标cnt块不存在时，新建该块
        p.right.left = q;
        q.right = p.right;
        p.right = q;
        q.left = p;
    }

    void remove(Block p) {  //当p块中没有Node时，删除p块
        p.left.right = p.right;
        p.right.left = p.left;
    }

    public LFUCache(int _capacity) {    //注意变量名不能重复！！否则赋值出错！！
        capacity = _capacity;
        bhead = new Block(0); btail = new Block(0x3f3f3f3f);    //维护外层LFU的头尾哨兵节点
        bhead.right = btail; btail.left = bhead;    //初始维护双链表
    }
    
    public int get(int key) {       //从LFU中取出一个节点，并跟新其操作次数
        if (!hash_block.containsKey(key)) return -1;    //该key不存在
        
        Node node = hash_node.get(key);     //得到该key所在的LRU节点
        Block block = hash_block.get(key);  //得到该key所在的LFU块
        
        if (block.right.cnt != block.cnt + 1) insert(block);    //块的cnt不连续，在该块后新建一个块
        block.remove(node);     //将node从block块中删除
        block.right.insert(node);   //将node节点添加到block后一个块中，更新其操作次数
        hash_block.put(key, block.right);   //更新该节点所在的block
        
        if (block.empty()) remove(block);       //当block为空时，删除该块，保证后续put时间复杂度为O(1)
        return node.val;    //返回获取到的值
    }
    
    public void put(int key, int value) {   //向LFU更新key对应的值
        if (capacity == 0) return ;     //没有容量，不能put
        if (hash_block.containsKey(key)) {  //LFU中有该节点
            Node node = hash_node.get(key);     //找到该节点的LRU的ndoe
            node.val = value;       //更新node的value值
            get(key);   //对key进行一次get，将其所属的block进行更新
        }
        else {          //LFU中没有该节点
            if (hash_block.size() == capacity) {       //LFU缓存已满
                Block block = bhead.right;      //找到使用次数最少的块
                Node node = block.tail.left;   //使用次数最少的块里的LRU链表尾部的节点
                int keyd = node.key;     //取到待删除节点的key
                
                block.remove(node);     //从block中删除该节点
                if (block.empty()) remove(block);   //当该块为空时，删除该块
                
                hash_block.remove(keyd); hash_node.remove(keyd);  //更新哈希表
            }
            Node nnode = new Node(key, value);      //创建该键值对的节点
            if (bhead.right.cnt != 1) insert(bhead);    //如果没有块1，则新建块1
            bhead.right.insert(nnode);  //将新节点插入块1中
            
            hash_block.put(key, bhead.right); hash_node.put(key, nnode);    //更新哈希表
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
