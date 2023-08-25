package AcWing.LeetCode;

class Solution {    //Gray编码+模板+思维题
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);     //当n=0时，只有0
        while (n-- > 0) {   //递推n次
            for (int i = res.size() - 1; i >= 0; i--) { //轴对称翻转
                res.set(i, res.get(i) * 2);     //轴对称上半部分二进制末尾补0
                res.add(res.get(i) + 1);    //轴对称下半部分二进制末尾补1
            }
        } 
        
        return res;
    }
}