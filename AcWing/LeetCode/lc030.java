package AcWing.LeetCode;

class Solution {   //滑动窗口+哈希表+等长间隔分组优化
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null) return res;
        int n = s.length(), m = words.length, w = words[0].length();
        
        Map<String, Integer> tot = new HashMap<>();     //存储words中每个单词及出现次数
        for (var word: words)   //将words中每个单词放入哈希表
            if (tot.containsKey(word)) tot.put(word, tot.get(word)+1);
            else tot.put(word, 1);

        for (int i = 0; i < w; i++) {   //分为w组，i为每组起始位置
            Map<String, Integer> wd = new HashMap<>();  //存储滑动窗口内的单词及次数
            int cnt = 0;    //存储滑动窗口内和tot中一样的单词的个数
            for (int j = i; j+w <= n; j += w) {  //每次往前走w个单位，注意<=，截取时j+w处不取，故<=!!
                if (j >= i + m * w) {    //滑动窗口内已装满m个单词，需移出窗口首元素，注意此判断的位置
                    var word = s.substring(j - m*w, j - m*w + w);   //截取要移除的元素
                    if (tot.containsKey(word) && wd.get(word) <= tot.get(word)) cnt--;  //更新cnt
                    wd.put(word, wd.get(word)-1);   //更新wd
                }
                
                var word = s.substring(j, j+w);     //截取出当前slot内的word
                if (wd.containsKey(word)) wd.put(word, wd.get(word)+1);     //更新滑动窗口
                else wd.put(word, 1);
                
                if (tot.containsKey(word) && wd.get(word) <= tot.get(word)) cnt++;  //更新cnt

                if (cnt == m) res.add(j - (m - 1) * w);   //找到一个子串
            }
        }

        return res;
    }
}