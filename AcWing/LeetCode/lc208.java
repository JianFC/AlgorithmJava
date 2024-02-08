package AcWing.LeetCode;        //208. 实现 Trie (前缀树)

class Trie {    //Trie模板 + 自定义节点
    class Node {    //定义trie树节点
        boolean is_end;     //以该节点结束是否有单词
        Node[] son = new Node[26];      //存储该节点的子节点，a - z映射为0 - 25
    }
    
    Node root;      //定义trie树根节点

    public Trie() {     //初始化
        root = new Node();  //创建根节点
    }
    
    public void insert(String word) {
        var p = root;   //从根节点开始
        for (int i = 0; i < word.length(); i ++) {
            int u = word.charAt(i) - 'a';   //将a - z映射为0 - 25便于管理
            if (p.son[u] == null) p.son[u] = new Node();    //对应节点不存在，创建出该节点
            p = p.son[u];   //走到下一个子节点
        }

        p.is_end = true;    //更新标记，以该节点结尾存在单词
    }
    
    public boolean search(String word) {
        var p = root;   //从根节点开始
        for (int i = 0; i < word.length(); i ++) {
            int u = word.charAt(i) - 'a';       //映射
            if (p.son[u] == null) return false;     //该单词不存在trie中
            p = p.son[u];   //存在则走到该店
        }

        return p.is_end;    //该路径存在，返回该节点是否是单词结尾
    }
    
    public boolean startsWith(String prefix) {
        var p = root;   //从根节点开始
        for (int i = 0; i < prefix.length(); i ++) {
            int u = prefix.charAt(i) - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }

        return true;    //检查前缀是否存在
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
