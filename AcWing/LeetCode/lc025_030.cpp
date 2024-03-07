#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int N = 100010;

vector<int> findSubstring(string s, vector<string>& words) {
    vector<int> res;
    if (words.empty()) return res;
    int n = s.size(), m = words.size(), w = words[0].size();
    unordered_map<string, int> tot;
    for (auto& word : words) tot[word] ++ ;

    for (int i = 0; i < w; i ++ ) {
        unordered_map<string, int> wd;
        int cnt = 0;
        for (int j = i; j + w <= n; j += w) {
            if (j >= i + m * w) {
                auto word = s.substr(j - m * w, w);
                wd[word] -- ;
                if (wd[word] < tot[word]) cnt -- ;
            }
            auto word = s.substr(j, w);
            wd[word] ++ ;
            if (wd[word] <= tot[word]) cnt ++ ;
            if (cnt == m) res.push_back(j - (m - 1) * w);
        }
    }

    return res;
}

int main() {
    vector<string> v1(10, "aaaa");
    findSubstring("aaaa", v1);

    return 0;
}