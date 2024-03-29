#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> tree, lazy_tree, leaf;


void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = leaf[start];
    else {
        int mid = (start + end)/2;
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
        tree[node] = tree[node*2] ^ tree[node*2 +1];
    }
}

void update_lazy_tree_child(int start, int end, int node, ll val)
{
    if (start != end) {
        lazy_tree[node*2] ^= val;
        lazy_tree[node*2 +1] ^= val;
    }
}

void lazy_update(int start, int end, int node)
{
    if (lazy_tree[node] != 0) {
        tree[node] ^= ((end-start+1) % 2)*lazy_tree[node];
        update_lazy_tree_child(start, end, node, lazy_tree[node]);
        lazy_tree[node] = 0;
    }
}

void update(int start, int end, int i, int j, ll val, int node = 1)
{
    lazy_update(start, end, node);
    if (j < start || end < i) return;
    if (i <= start && end <= j) {
        tree[node] ^= ((end-start+1) % 2) * val;
        update_lazy_tree_child(start, end, node, val);
    } else {
        int mid = (start + end)/2;
        update(start, mid, i, j, val, node*2);
        update(mid+1, end, i, j, val, node*2 +1);
        tree[node] = tree[node*2] ^ tree[node*2 +1];
    }
}

ll query(int start, int end, int i, int j, int node = 1)
{
    lazy_update(start, end, node);
    if (j < start || end < i) return 0;
    if (i <= start && end <= j) return tree[node];
    int mid = (start + end)/2;
    return query(start, mid, i, j, node*2) ^ query(mid+1, end, i, j, node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    {
        cin >> N;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
        lazy_tree.resize(size);
        init(1, N);
        cin >> M;
    }
    int type, i, j;
    while (M--) {
        cin >> type >> i >> j;
        if (type == 1){
            ll k;
            cin >> k;
            update(1, N, i+1, j+1, k);
        } else cout << query(1, N, i+1, j+1) << '\n';
    }
}
