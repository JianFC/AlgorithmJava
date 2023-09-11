package AcWing.LeetCode;

class Solution {    //BFS + 建图
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> S = new HashSet<>();    //哈希表
        for (int i = 0; i < wordList.size(); i ++) S.add(wordList.get(i));
        
        Map<String, Integer> dist = new HashMap<>();    //最短路数组
        Queue<String> q = new LinkedList<>();
        
        dist.put(beginWord, 0); //初始化
        q.offer(beginWord);

        while (q.size() > 0) {  //BFS
            var t = q.poll();

            char[] sc = t.toCharArray();
            for (int i = 0; i < sc.length; i ++) {
                sc = t.toCharArray();   //恢复
                for (char j = 'a'; j <= 'z'; j ++) {
                    sc[i] = j;
                    String s = String.valueOf(sc);
                    if (S.contains(s) && !dist.containsKey(s)) {
                        dist.put(s, dist.get(t) + 1);   //更新s
                        if (s.equals(endWord)) return dist.get(s) + 1;  //算上起点
                        q.offer(s);
                    }
                }
            }
        }
        
        return 0;   //未找到答案
    }
}
