package AcWing.LeetCode;        //3. 无重复字符的最长子串

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> heap = new HashMap<>();

        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);

            if (!heap.containsKey(ch)) heap.put(ch, 1);
            else heap.put(ch, heap.get(ch) + 1);

            while (j <= i && heap.get(ch) > 1) {
                heap.put(s.charAt(j), heap.get(s.charAt(j)) - 1);
                j ++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
