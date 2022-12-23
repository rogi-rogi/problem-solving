#include <cmath>
#include <iostream>
#include <vector>
#define ll unsigned long long
using namespace std;

vector<ll> tree, leaf;

void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = leaf[start];
    else {
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}

void update(int start, int end, int idx, int val, int node = 1)
{
    if (start <= idx && idx <= end) {
        if (start == end) tree[node] = leaf[idx] = val;
        else {
            int mid = (start + end) / 2;
            update(start, mid, idx, val, node * 2);
            update(mid + 1, end, idx, val, node * 2 + 1);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}

ll query(int start, int end, int i, int j, int node = 1)
{
    if (start > j || end < i) return 0;
    if (i <= start && end <= j) return tree[node];
    else {
        int mid = (start + end) / 2;
        return (query(start, mid, i, j, node * 2) + query(mid + 1, end, i, j, node * 2 + 1));
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, Q;
    { // input leaf & init tree
        cin >> N >> Q;
        leaf.resize(N + 1);
        for (int i = 1; i < N + 1; ++i) cin >> leaf[i];
        int h = (int)ceil(log2(N));
        int size = (1 << (h + 1));
        tree.resize(size + 1);
        init(1, N);
    }
    while (Q--) {
        int x, y, a, b;
        cin >> x >> y >> a >> b;
        if (x > y) swap(x, y);
        cout << query(1, N, x, y) << '\n';
        update(1, N, a, b);
    }
}
