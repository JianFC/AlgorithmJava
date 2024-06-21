package AcWing.LeetCode;        //187. 重复的DNA序列

class Solution {    //哈希 + 时O(n) + 进阶可用字符串哈希
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> hash = new HashMap<>();    //存储长度为10的子串的哈希表
        for (int i = 0; i + 10 <= s.length(); i ++)     //注意为i + 10 <= s.lenght()
            hash.put(s.substring(i, i + 10), hash.getOrDefault(s.substring(i, i + 10), 0) + 1);    //更新hash表
        
        List<String> res = new ArrayList<>();
        for (String k : hash.keySet()) 
            if (hash.get(k) > 1) res.add(k);    //出现次数大于1
        
        return res;
    }
}
