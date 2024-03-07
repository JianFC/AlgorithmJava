#include <iostream>         // 分支做法，时间O(n), 空间O(logn)
#include <algorithm>
#include <vector>

using namespace std;

struct Node {
    int sum, s, ls, rs;
};

Node build(vector<int>& nums, int l, int r) {
    if (l == r) {
        int v = max(nums[l], 0);
        return {nums[l], v, v, v};
    }

    int mid = l + r >> 1;
    auto L = build(nums, l, mid), R = build(nums, mid + 1, r);
    Node res;
    res.sum = L.sum + R.sum;
    res.s = max(max(L.s, R.s), L.rs + R.ls);
    res.ls = max(L.ls, L.sum + R.ls);
    res.rs = max(R.rs, R.sum + L.rs);
    return res;
}

int maxSubArray(vector<int>& nums) {
    int res = INT_MIN;
    for (auto x: nums) res = max(res, x);
    if (res < 0) return res;
    
    auto t = build(nums, 0, nums.size() - 1);
    return t.s;
}

int main() {
    vector<int> nums(10, 1000);
    maxSubArray(nums);

    return 0;
}