package AcWing.LeetCode;        //13. 罗马数字转整数

import java.util.*;

class Solution {
    public int romanToInt(String s) {   //模拟
        //时间复杂度O(logN), ref link: https://www.acwing.com/activity/content/code/content/346746/
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5);
        map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500);
        map.put('M', 1000); 

        int res = 0;
        for (int i = 0; i < s.length(); i ++)
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                res -= map.get(s.charAt(i));
            else 
                res += map.get(s.charAt(i));
        
        return res;
    }
}
