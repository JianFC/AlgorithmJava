package AcWing.LeetCode;        //438. 找到字符串中所有字母异位词

class Solution {    //双指针 + 滑动窗口 + 哈希表 + 时O(n)
    public List<Integer> findAnagrams(String s, String p) {
        //hashp表示p的字符哈希表, hashw表示滑动窗口的哈希表
        Map<Character, Integer> hashp = new HashMap<>(), hashw = new HashMap<>();     
        for (int i = 0; i < p.length(); i ++)
            hashp.put(p.charAt(i), hashp.getOrDefault(p.charAt(i), 0) + 1);     //更新哈希表hashp

        List<Integer> res = new ArrayList<>();      //记录结果
        int cnt = p.length(), tot = 0;   //cnt记录有效字符的个数, tot记录滑动窗口中所有有效字符的数量 
        for (int i = 0, j = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (hashw.getOrDefault(c, 0) < hashp.getOrDefault(c, 0)) tot ++;    //更新有效字符的数量
            hashw.put(c, hashw.getOrDefault(c, 0) + 1);     //更新滑动窗口

            while (i - j + 1 > p.length()) {    //维护滑动窗口区间长度，可以写if
                char t = s.charAt(j);
                if (hashw.get(t) <= hashp.getOrDefault(t, 0)) tot --;   //维护有效字符数量，弹出t
                hashw.put(t, hashw.get(t) - 1);     //更新哈希表
                j ++;   //更新j
            }

            if (tot == cnt) res.add(j);     //找到一个合法子串
        }

        return res;
    }
}
