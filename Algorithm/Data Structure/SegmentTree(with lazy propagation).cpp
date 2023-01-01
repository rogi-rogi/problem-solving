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
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}
void update_lazy_tree(int start, int end, int node, ll diff)
{
    if (start != end) {
        lazy_tree[node*2] += diff;
        lazy_tree[node*2 +1] += diff;
    }
}

void lazy_update(int start, int end, int node)
{
    if (lazy_tree[node] != 0) {
        tree[node] += (end-start+1)*lazy_tree[node];
        update_lazy_tree(start, end, node, lazy_tree[node]);
        lazy_tree[node] = 0;
    }
}

void update(int start, int end, int i, int j, ll diff, int node = 1)
{
    lazy_update(start, end, node);
    if (j < start || end < i) return;
    if (i <= start && end <= j) {
        tree[node] += (end-start+1)*diff;
        update_lazy_tree(start, end, node, diff);
    } else {
        int mid = (start + end)/2;
        update(start, mid, i, j, diff, node*2);
        update(mid+1, end, i, j, diff, node*2 +1);
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
    int N, Q;
    {
        cin >> N >> Q;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
        lazy_tree.resize(size);
        init(1, N);
    }
    int type;
    while (Q--) {
        cin >> type;
        if (type == 1) {
            int i, j;
            ll diff;
            cin >> i >> j >> diff;
            update(1, N, i, j, diff);
        } else {
            int i, j;
            cin >> i >> j;
            cout << query(1, N, i, j) << '\n';
        }
    }
}
