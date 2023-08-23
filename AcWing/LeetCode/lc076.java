package AcWing.LeetCode;

class Solution {    //双指针+滑动窗口+哈希表+思维题
    public String minWindow(String s, String t) {
        //ht代表t的哈希表，hw代表滑动窗口的哈希表
        Map<Character, Integer> ht = new HashMap<>(), hw = new HashMap<>();
        
        //更新ht
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (ht.containsKey(c)) ht.put(c, ht.get(c) + 1);
            else ht.put(c, 1);
        }

        String res = "";    //存储答案
        int cnt = 0;    //存储滑动窗口内有效字符的数量
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hw.containsKey(c)) hw.put(c, hw.get(c) + 1);
            else hw.put(c, 1);    //更新hw

            if (ht.containsKey(c) && hw.get(c) <= ht.get(c)) cnt++;    //更新有效数量
            
            char cj  = s.charAt(j);
            while (j < i && (!ht.containsKey(cj) || hw.get(cj) > ht.get(cj))) { //cj是多余字符，j++
                hw.put(cj, hw.get(cj) - 1);
                j++; cj = s.charAt(j);  //更新j和cj
            }
            
            if (cnt == t.length()) {    //找到一个覆盖字串
                //res为空or当前覆盖字串长度更小
                if (res.length() == 0 || i - j + 1 < res.length())
                    res = s.substring(j, i + 1);    //更新res
            }
        }

        return res;
    }
}
