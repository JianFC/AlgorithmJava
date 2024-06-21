package AcWing.LeetCode;        //211. 添加与搜索单词 - 数据结构设计

class WordDictionary {  //Trie树 + 暴搜 + 迭代改递归
    class Node {
        boolean is_end;     //标记是否有单词以该节点结尾
        Node[] son = new Node[26];      //该节点的子节点
    }

    Node root;      //trie树根节点

    public WordDictionary() {
        root = new Node();  //初始化trie树
    }
    
    public void addWord(String word) {
        var p = root;   //从根节点开始遍历
        for (int i = 0; i < word.length(); i ++) {
            int u = word.charAt(i) - 'a';   //下标映射
            if (p.son[u] == null) p.son[u] = new Node();    //创建节点
            p = p.son[u];   //走到下一个节点
        }
        p.is_end = true;    //标记该节点是单词结尾
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);  //迭代改递归，从根节点暴搜，看该单词是否存在，i表示走到的位置
    }

    boolean dfs(Node p, String word, int i) {
        if (i == word.length()) return p.is_end;    //看该单词是否存在
        if (word.charAt(i) != '.') {    //按照正常方式查找
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) return false;     //该单词不存在
            return dfs(p.son[u], word, i + 1);  //继续搜索下一个位置
        }
        else {  //该位置是.,遍历所有儿子节点搜索
            for (int j = 0; j < 26; j ++)
                if (p.son[j] != null && dfs(p.son[j], word, i + 1)) //注意搜索条件，一个找到即为true
                    return true;    
            return false;   //所有节点都没找到，此时为false
        }
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
