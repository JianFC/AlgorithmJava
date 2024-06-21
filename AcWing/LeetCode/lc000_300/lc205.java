package AcWing.LeetCode;        //205. 同构字符串

class Solution {    //哈希表 + 思维题 + 时O(n)
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>(), ts = new HashMap<>();   //s -> t和t -> s的哈希表
        for (int i = 0; i < s.length(); i ++) {     //两个字符串长度相等
            char a = s.charAt(i), b = t.charAt(i);
            if (st.containsKey(a) && st.get(a) != b) return false;  //一个字符映射到多个字符，不合法
            st.put(a, b);   //更新正向st哈希表
            if (ts.containsKey(b) && ts.get(b) != a) return false;  //一个字符被多个字符映射，不合法
            ts.put(b, a);   //更新逆向ts哈希表 
        }
        return true;    //两个字符串同构
    }
}
