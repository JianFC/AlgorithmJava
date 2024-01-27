package AcWing.LeetCode;        //139. 单词拆分

class Solution {    //字符串哈希优化时间复杂度(O(n^2)) + 秦九韶算法 + 线性DP
    public boolean wordBreak(String s, List<String> wordDict) {
        int P = 131;
        Set<Long> hash = new HashSet<>();   //存储每个字符串的哈希值
        for (var str: wordDict) {   //预处理每个单词的hash
            long h = 0;
            for (int i = 0; i < str.length(); i ++)
                h = h * P + str.charAt(i);  //字符串哈希
            hash.add(h); 
        }

        int n = s.length();
        boolean[] f = new boolean[n + 1];   //f[i]表示s1-si中是否存在合法的划分方案
        f[0] = true;    //边界
        s = ' ' + s;    //下标从1开始
        for (int i = 0; i < n; i ++)    //从0开始，往后递推i后面的状态，便于计算子串hash值
            if (f[i]) {
                long h = 0;
                for (int j = i + 1; j <= n; j ++) { //往后看i后面的状态
                    h = h * P + s.charAt(j);    //子串hash值
                    if (hash.contains(h)) f[j] = true;
                }
            }

        return f[n];
    }
}
