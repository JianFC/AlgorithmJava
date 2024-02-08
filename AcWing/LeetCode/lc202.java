package AcWing.LeetCode;

class Solution {    //思维题 + 时O(1)（最多执行812次）+ 快慢指针
    int get(int x) {    //计算x的下一个数
        int res = 0;
        while (x != 0) {
            res += (x % 10) * (x % 10);
            x /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int fast = get(n), slow = n;    //定义快慢指针
        while (fast != slow) {
            fast = get(get(fast));      //快指针走两步
            slow = get(slow);       //慢指针走一步
        }

        return fast == 1;   //快乐数当且仅当最后循环圈内只有1
    }
}