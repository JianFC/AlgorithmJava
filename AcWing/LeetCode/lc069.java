package AcWing.LeetCode;

class Solution {    //简单二分
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (int)(l + 1L + r >> 1);   //防止越界
            if (mid <= x / mid) l = mid;        //* -> /，防止越界 
            else r = mid - 1;
        }

        return l;
    }
}
