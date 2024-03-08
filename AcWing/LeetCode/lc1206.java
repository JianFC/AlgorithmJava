class Skiplist {    //数据结构 + 模板题 + 时O(logn)
    final static int level = 8;     //定义跳表的层数，（最后一层可能不是一个，每一层的节点按照50%的概率往下层跳）
    class Node {    //跳表每个节点的结构，存储了该节点在每一层的next，特定层的next可能为空
        int val;    //该节点存储的值
        Node[] next;    //next[i]表示第i层（原序列是第0层）当前节点的下一个Node节点，有许多节点的next[i]没有值
        Node (int _val) {
            val = _val;     //更新节点val值
            next = new Node[level];
        }
    }
    
    Node head;      //定义跳表的虚拟头节点哨兵
    Random random = new Random();   //用于产生随机数，控制新增节点是否往上跳，全局初始化防止每次新建

    public Skiplist() {
        head = new Node(-1);    //初始化哨兵，其next数组预分配了8个Node的空间，但每个next中每个元素为空
    }

    //在跳表中找到每一层i中小于target的最大数，存储在pre[i]中
    void find(int target, Node[] pre) {
        Node p = head;      //从头虚拟节点开始
        for (int i = level - 1; i >= 0; i --) {     //从最下层的节点最少的链开始找
            while (p.next[i] != null && p.next[i].val < target) p = p.next[i];  //不断往后走到小于target的最大数
                            //并且让上一层从下一层找到的位置p开始，继续往后
            pre[i] = p;     //更新每一层的pre数组
        }
    }

    public boolean search(int target) {     //在跳表中查询一个元素是否存在
        Node[] pre = new Node[level];   
        find(target, pre);          //记录跳表每一层中小于target的最大数的节点
        return pre[0].next[0] != null && pre[0].next[0].val == target;
        //看第0层的节点的第0层的后续节点值是否为target      
    }
    
    public void add(int num) {      //在跳表中插入一个节点
        Node[] pre = new Node[level];
        find(num, pre);
        
        Node p = new Node(num);
        for (int i = 0; i < level; i ++) {      //从第0层开始往下看是否需要加到跳表中，第0层一定加，后面每次50%概率
            p.next[i] = pre[i].next[i];     //在跳表第i层添加p节点
            pre[i].next[i] = p;
            if (random.nextInt(2) == 0) break;  //新加入节点p后除第一层外，每次以50%的概率往下层添加节点p
        }
    }
    
    public boolean erase(int num) {     //在跳表中删除一个节点
        Node[] pre = new Node[level];
        find(num, pre);

        Node p = pre[0].next[0];    //找到第0层中小于num的最大数
        if (p == null || p.val != num) return false;    //该值在跳表中不存在
        //过了if判断即p为待删除的Node节点
        
        for (int i = 0; i < level && pre[i].next[i] == p; i ++)  //当p一直存在时，从第0层往下逐层删，时间复杂度O(logn)
            pre[i].next[i] = p.next[i];     //删除每一层第p个节点
        
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */