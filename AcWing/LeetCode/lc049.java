package AcWing.LeetCode;        //49. 字母异位词分组

class Solution {    //思维题
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();   //key是每组字符串的升序排列
        for (String str: strs) {
            char[] nstr = str.toCharArray();
            Arrays.sort(nstr, 0, nstr.length);  //按照字典序排列
            
            String sstr = String.valueOf(nstr);
            if (hash.containsKey(sstr)) hash.get(sstr).add(str);
            else {
                List<String> ls = new ArrayList<>(); ls.add(str);
                hash.put(sstr, ls);
            }
        }

        List<List<String>> res = new ArrayList<>();
        Set<String> keys = hash.keySet();
        for (String key: keys) res.add(hash.get(key));

        return res;
    }
}
