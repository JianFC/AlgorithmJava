package AcWing.LeetCode;
//126. 单词接龙 II

class Solution {    //BFS + DFS + 建图 + 路径搜索(时间复杂度指数级别) + 求最短路路径模板
    Set<String> S = new HashSet<>();    //哈希表，存储每个单词是否出现过
    Map<String, Integer> dist = new HashMap<>();    //dist[i]存储单词i到bw的最短距离
    Queue<String> q = new LinkedList<>();       //q宽搜dist队列
    List<List<String>> ans = new ArrayList<>();     //存储答案
    List<String> path = new ArrayList<>();          //存储搜索路径
    String bw = "";     //存储开始单词
    
    public List<List<String>> findLadders(String _bw, String ew, List<String> wl) {
        bw = _bw;
        for (int i = 0; i < wl.size(); i ++) S.add(wl.get(i));   //加入哈希表
        dist.put(bw, 0);    //更新起点dist
        q.offer(bw);    //起点加入队列

        while (q.size() > 0) {  //BFS求dist
            var t = q.poll();   //取队头
            
            char[] sc = t.toCharArray();
            for (int i = 0; i < sc.length; i ++) {   //建图，枚举可能变成的单词
                sc = t.toCharArray();   //恢复
                for (int j = 'a'; j <= 'z'; j ++) {  //枚举第i位的转换
                    sc[i] = (char)j;
                    String s = String.valueOf(sc);  //转为字符串
                    if (S.contains(s) && !dist.containsKey(s)) {    //wl中有且dist未算过
                        dist.put(s, dist.get(t) + 1);   //更新单词s的距离
                        if (s.equals(ew)) break;    //搜到终点，break
                        q.offer(s); //入队
                    }
                }
            }
        }

        if (!dist.containsKey(ew))  return ans;     //没有合法路径
        path.add(ew);   
        dfs(ew);    //从终点开始往回搜，dfs求路径
        return ans;
    }

    void dfs(String t) {
        if (t.equals(bw)) {     //搜到一条合法路径
            Collections.reverse(path);  //从bw -> ew
            ans.add(new ArrayList(path));
            Collections.reverse(path);  //恢复倒序，不影响其他路径
            return ; 
        }
        else {
            char[] sc = t.toCharArray();
            for (int i = 0; i < sc.length; i ++) {  //看t上一个单词可能是啥
                sc = t.toCharArray();
                for (int j = 'a'; j <= 'z'; j++) {
                    sc[i] = (char)j;
                    String s = String.valueOf(sc);
                    if (dist.containsKey(s) && dist.get(s) + 1 == dist.get(t)) {    //剪枝条件，最短路性质
                        path.add(s);    //加入合法路径
                        dfs(s);     //继续搜索
                        path.remove(path.size() - 1);   //恢复现场
                    }
                }
            }   
        }
    }
}
