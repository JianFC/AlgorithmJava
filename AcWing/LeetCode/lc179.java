package AcWing.LeetCode;    //179. 最大数

class Solution {    //数学推导 + 自定义排序 + 时O(nlogn)
    public String largestNumber(int[] ns) {
        Integer[] nums = Arrays.stream(ns).boxed().toArray(Integer[]::new);  //int[]不能自定义排序规则，需转为Integer
        Arrays.sort(nums, 0, nums.length, (o1, o2) -> {
            String a = String.valueOf(o1), b = String.valueOf(o2);
            return (b + a).compareTo(a + b);    //按照自定义排序降序排序，已证明(a >= b) <=> (ab >= ba)是全序关系
        });
       
        StringBuilder res = new StringBuilder();
        for (int x : nums) res.append(String.valueOf(x));   //将排序后的数组拼接成答案
        int k = 0;  //用于去掉前导0
        while (k + 1 < res.length() && res.charAt(k) == '0') k ++;  //k + 1 < res.size()保留最后一个0
        return res.toString().substring(k);     //返回字符串形式答案
    }
}
