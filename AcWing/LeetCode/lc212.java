package AcWing.LeetCode;        //212. 单词搜索 II

class Solution {    //路径暴力搜索 + trie树剪枝 + 时O(nm4 * 3^(k - 2)) k为搜索路径平均长度
    class Node {
        int id;     //存储该节点是否有单词结尾，有的话在words中下标为多少
        Node[] son = new Node[26];      //维护子节点
        Node() {
            id = -1;    //初始化id为-1
        }
    }
    
    Node root = new Node();     //创建trie树根节点
    char[][] g;     //将board存储为全局变量
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};   //棋盘搜索时方向向量
    Set<Integer> ids = new HashSet<>();     //存储存在的单词id的哈希表

    void insert(String word, int id) {      //trie树插入函数
        var p = root;
        for (int i = 0; i < word.length(); i ++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }

        p.id = id;      //标记id
    }

    public List<String> findWords(char[][] board, String[] words) {
        g = board;
        for (int i = 0; i < words.length; i ++) insert(words[i], i);  //将words插入trie树

        for (int i = 0; i < g.length; i ++)     //从每个起点开始搜索
            for (int j = 0; j < g[0].length; j ++) {
                int u = g[i][j] - 'a';      //映射下标
                if (root.son[u] != null)    //有以该字母开头的单词
                    dfs(i, j, root.son[u]);     //从该点开始继续搜索
            }
        
        List<String> res = new ArrayList<>();   //存储答案
        for (int id : ids) res.add(words[id]);   //将存在的单词加入res
        return res;     //返回答案
    }

    void dfs(int x, int y, Node p) {
        if (p.id != -1) ids.add(p.id);      //搜到一个单词，哈希表去重
        char t = g[x][y];   //外部搜索，用于后续恢复现场
        g[x][y] = '.';      //标记该点已经被搜过
        for (int i = 0; i < 4; i ++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < g.length && b >= 0 && b < g[0].length && g[a][b] != '.') {      //合法性检查
                int u = g[a][b] - 'a';      //下标映射
                if (p.son[u] != null) dfs(a, b, p.son[u]);  //利用trie树进一步剪枝
            }
        }

        g[x][y] = t;    //外部搜索，注意恢复现场
    }
}