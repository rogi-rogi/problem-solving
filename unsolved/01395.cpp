#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> tree, lazy_tree;

void update_lazy_tree(int start, int end, int node, ll diff)
{
    if (start != end) {
        lazy_tree[node*2] += diff;
        lazy_tree[node*2 +1] += diff;
    }
}

void lazy_update(int start, int end, int node)
{
    if (lazy_tree[node] % 2) {
        tree[node] = (end-start+1) - tree[node];
        update_lazy_tree(start, end, node, lazy_tree[node]);
        lazy_tree[node] = 0;
    }
}

void update(int start, int end, int i, int j, int node = 1)
{
    lazy_update(start, end, node);
    if (j < start || end < i) return;
    if (i <= start && end <= j) {
        tree[node] = (end-start+1) - tree[node];
        update_lazy_tree(start, end, node, 1);
    } else {
        int mid = (start + end)/2;
        update(start, mid, i, j, node*2);
        update(mid+1, end, i, j, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

ll query(int start, int end, int i, int j, int node = 1)
{
    lazy_update(start, end, node);
    if (j < start || end < i) return 0;
    if (i <= start && end <= j) return tree[node];
    int mid = (start + end)/2;
    return query(start, mid, i, j, node*2) + query(mid+1, end, i, j, node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    {
        cin >> N >> M;
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
        lazy_tree.resize(size);
    }
    int type, i, j;
    while (M--) {
        cin >> type >> i >> j;
        if (type == 0) update(1, N, i, j);
        else cout << query(1, N, i, j) << '\n';
    }
}
