package AcWing.LeetCode;    //66. 加一

class Solution {    //模拟题 + 高精度加法思想
    public int[] plusOne(int[] di) {
        List<Integer> res = new ArrayList<>();
        reverse(di, 0, di.length - 1);    //翻转di
        //t表示进位，+ 1可视为从上一位进一位
        int t = 1;
        for (int i = 0; i < di.length; i ++) {    
            t += di[i];
            res.add(t % 10);
            t /= 10;
        }

        if (t > 0) res.add(t);  //处理最高位进位
        Collections.reverse(res);

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) ans[i] = res.get(i);

        return ans;
    }

    void reverse(int[] nums, int l, int r) {    //翻转数组
        while (l < r) {
            int t = nums[l]; nums[l] = nums[r]; nums[r] = t;
            l ++; r --;
        }
    }
}