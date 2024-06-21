#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

const int N = 100010;

unordered_set<string> S;
unordered_map<string, int> dist;
queue<string> q;
vector<vector<string>> ans;
vector<string> path;
string beginWord;

vector<vector<string>> findLadders(string _beginWord, string endWord, vector<string>& wordList) {
    for (auto word: wordList) S.insert(word);
    beginWord = _beginWord;
    dist[beginWord] = 0;
    q.push(beginWord);
    while (q.size()) {
        auto t = q.front();
        q.pop();

        string r = t;
        for (int i = 0; i < t.size(); i ++ ) {
            t = r;
            for (char j = 'a'; j <= 'z'; j ++ ) {
                t[i] = j;
                if (S.count(t) && dist.count(t) == 0) {
                    dist[t] = dist[r] + 1;
                    if (t == endWord) break;
                    q.push(t);
                }
            }
        }
    }

    if (dist.count(endWord) == 0) return ans;
    path.push_back(endWord);
    dfs(endWord);
    return ans;
}

void dfs(string t) {
    if (t == beginWord) {
        reverse(path.begin(), path.end());
        ans.push_back(path);
        reverse(path.begin(), path.end());
    } else {
        string r = t;
        for (int i = 0; i < t.size(); i ++ ) {
            t = r;
            for (char j = 'a'; j <= 'z'; j ++ ) {
                t[i] = j;
                if (dist.count(t) && dist[t] + 1 == dist[r]) {
                    path.push_back(t);
                    dfs(t);
                    path.pop_back();
                }
            }
        }
    }
}

int main() {
    vector<string> v1(10, "bbbb");
    findLadders("aaa", "bbb", v1);

    return 0;
}

