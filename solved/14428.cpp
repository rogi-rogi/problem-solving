#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

vector<int> tree, leaf;

int minIndex(int l_idx, int r_idx)
{
    if (l_idx == -1) return r_idx;
    if (r_idx == -1) return l_idx;
    return (leaf[l_idx] <= leaf[r_idx]) ? l_idx : r_idx;
}

void init(int start, int end, int node)
{
    if (start == end) tree[node] = start; // or end, recode index
    else {
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = minIndex(tree[node * 2], tree[node * 2 + 1]);
    }
}

void update(int start, int end, int node, int idx, int val)
{
    if (start <= idx && idx <= end) {
        if (start == end) {
            leaf[idx] = val;
            tree[node] = idx;
        } else {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, idx, val);
            update(mid + 1, end, node * 2 + 1, idx, val);
            tree[node] = minIndex(tree[node * 2], tree[node * 2 + 1]);
        }
    }
}

int query(int start, int end, int node, int i, int j)
{
    if (start > j || end < i) return -1;
    if (i <= start && end <= j) return tree[node];
    else {
        int mid = (start + end) / 2;
        return minIndex(query(start, mid, node * 2, i, j), query(mid + 1, end, node * 2 + 1, i, j));
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    {
        int N;
        cin >> N;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int h = (int)ceil(log2(N));
        int size = (1 << (h + 1));
        tree.resize(size + 1);
        init(1, N, 1);
    }
    int M;
    cin >> M;
    while (M--) {
        int mode, i, j;
        cin >> mode >> i >> j;
        if (mode == 1) update(1, N, 1, i, j);
        else cout << query(1, N, 1, i, j) << '\n';
    }
}
