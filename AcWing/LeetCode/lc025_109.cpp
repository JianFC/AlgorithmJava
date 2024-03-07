#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(NULL), right(NULL) {}
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x): val(x), next(NULL) {}
    ListNode(int x, ListNode* next): val(x), next(next) {}
};

TreeNode* sortedListToBST(ListNode* head) {
      if (!head) return NULL;
    int n = 0;
    for (auto p = head; p; p = p->next) n ++ ;
    if (n == 1) return new TreeNode(head->val);
    auto cur = head;
    for (int i = 0; i < n / 2 - 1; i ++ ) cur = cur->next;
    auto root = new TreeNode(cur->next->val);
    root->right = sortedListToBST(cur->next->next);
    cur->next = NULL;
    root->left = sortedListToBST(head);
    return root;
}

int main() {
    sortedListToBST(new ListNode(1));

    return 0;
}