package AcWing.LeetCode;

class Solution {    //哈希表 + 思维题 + 双指针
    public int longestConsecutive(int[] nums) {
        Set<Integer> S = new HashSet<>();   //哈希表，存储出现的每个数
        for (var t: nums) S.add(t);     //将每个数加入哈希表

        int res = 0;    //存储答案
        for (var t: nums) {
            if (!S.contains(t - 1)) {   //保证t是每一段的起点
                S.remove(t); //将t从哈希表中删除，保证每个数只会被搜一次
                int y = t;
                while (S.contains(y + 1)) {
                    y ++;
                    S.remove(y); //将后一个数从哈希表删掉，保证O(n)
                }

                res = Math.max(res, y - t + 1);  //更新答案
            }
        }

        return res;
    }
}
