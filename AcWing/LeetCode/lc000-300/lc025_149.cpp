#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

int maxPoints(vector<vector<int>>& points) {
    typedef long double LD;

    int res = 0;
    for (auto& p: points) {
        int ss = 0, vs = 0;
        unordered_map<LD, int> cnt;
        for (auto& q: points)
            if (p == q) ss ++ ;
            else if (p[0] == q[0]) vs ++ ;
            else {
                LD k = (LD)(q[1] - p[1]) / (q[0] - p[0]);
                cnt[k] ++ ;
            }
        int c = vs;
        for (auto [k, t]: cnt) c = max(c, t);
        res = max(res, c + ss);
    }
    return res;
}

int main() {
    vector<vector<int>> points(10, vector<int>(2, 999));
    maxPoints(points);

    return 0;
}

