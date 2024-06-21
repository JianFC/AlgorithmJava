package AcWing.LeetCode;        //763. 划分字母区间

class Solution {    //思维题 + 模拟题 + 时O(n)
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> last = new HashMap<>();   //记录每个字母最后出现的位置
        for (int i = 0; i < s.length(); i ++) last.put(s.charAt(i), i);
        List<Integer> res = new ArrayList<>();  //存储答案
        int start = 0, end = 0;     //第一段合法区间
        for (int i = 0; i < s.length(); i ++) {
            end = Math.max(end, last.get(s.charAt(i)));     //end为max(end, 当前字符最后出现位置)
            if (i == end) {     //找到一个合法区间
                res.add(end - start + 1);   //存储合法区间长度
                start = end = i + 1;    //开始一个新区见
            }
        }

        return res;
    }
}
