#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
#define ll unsigned long long
using namespace std;

vector<ll> tree, leaf;

void init(int start, int end, int node)
{
    if (start == end) tree[node] = (leaf[start] = 0);
    else {
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}

void Modify(int start, int end, int node, int idx, int val)
{
    if (start <= idx && idx <= end) {
        if (start == end) tree[node] = leaf[idx] = val;
        else {
            int mid = (start + end) / 2;
            Modify(start, mid, node * 2, idx, val);
            Modify(mid + 1, end, node * 2 + 1, idx, val);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}

ll Sum(int start, int end, int node, int i, int j)
{
    if (start > j || end < i) return 0;
    if (i <= start && end <= j) return tree[node];
    else {
        int mid = (start + end) / 2;
        return (Sum(start, mid, node * 2, i, j) + Sum(mid + 1, end, node * 2 + 1, i, j));
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    cin >> N >> M;
    leaf.resize(N + 1, 0);
    int h = (int)ceil(log2(N));
    int size = (1 << (h + 1));
    tree.resize(size + 1);
    init(1, N, 1);
    while (M--) {
        int mode, i, j;
        cin >> mode >> i >> j;
        if (mode == 0) {
            if (i > j) swap(i, j);
            cout << Sum(1, N, 1, i, j) << '\n';
        } else Modify(1, N, 1, i, j);
    }
}
