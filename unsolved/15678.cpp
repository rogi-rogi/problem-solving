#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> tree, leaf;

void update(int start, int end, int idx, int node = 1)
{
    if (end < idx || idx < start) return;
    if (start == end) tree[node] = leaf[idx];
    else {
        int mid = (start + end)/2;
        update(start, mid, idx, node*2);
        update(mid+1, end, idx, node*2 +1);
        tree[node] = max(tree[node*2], tree[node*2 +1]);
    }
}

ll query(int start, int end, int i, int j, int node = 1)
{
    if (j < start || end < i) return -1000000000;
    if (i <= start && end <= j) return tree[node];
    int mid = (start + end)/2;
    return max(query(start, mid, i, j, node*2), query(mid+1, end, i, j, node*2 +1));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, D;
    {
        cin >> N >> D;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
    }
    for (int i = 1; i <= N; ++i) {
        ll val = query(1, N, max(1, i - D), i - 1);
        if (val > 0) leaf[i] += val;
        update(1, N, i);
    }
    for (auto val : leaf) {
        cout << val << '\n';
    }
    cout << *max_element(leaf.begin() + 1, leaf.end());
}
