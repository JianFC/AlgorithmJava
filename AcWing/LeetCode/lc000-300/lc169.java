package AcWing.LeetCode;        //169. 多数元素

class Solution {    //思维题 + 时O(n)空O(1)
    public int majorityElement(int[] nums) {
        int r = 0, c = 0;   //r表示当前存的数，c表示r的数量(库存)
        for (int x : nums)      //从前往后扫描每个数
            if (c == 0) {
                r = x; c ++;    //当库存为0时，更新r和c
            }
            else if (x == r) c ++;      //当x和r相同，库存 ++
            else c --;      //当x和r不同时，库存 --，消耗掉一个r，最终r保存的一定是多数元素
        
        return r;
    }
}