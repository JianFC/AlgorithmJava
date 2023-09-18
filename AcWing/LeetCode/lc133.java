package AcWing.LeetCode;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {    //图的遍历DFS + 哈希表
    Map<Node, Node> hash = new HashMap<>();     //存储旧点到新点的映射

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);  //复制所有点，时间复杂度O(n)

        for (var kv: hash.entrySet())   //复制所有边 O(m)
            for (var ver: kv.getKey().neighbors)
                kv.getValue().neighbors.add(hash.get(ver));   

        return hash.get(node);
    }

    void dfs(Node u) {  //遍历图，复制图中的节点
        Node t = new Node(u.val);  //复制节点
        hash.put(u, t);     //加入哈希表
        for (var ver: u.neighbors)
            if (!hash.containsKey(ver))    //没有遍历过
                dfs(ver);   //遍历该点
    }
}