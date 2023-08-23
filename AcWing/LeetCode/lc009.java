package AcWing.LeetCode;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long s = 0, y = x;     //逆序可能会溢出
        while (x != 0) {
            s = s * 10 + x % 10;
            x /= 10;
        }

        return s == y;
    }
}