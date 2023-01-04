#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> lazy_tree, leaf;

void lazy_update(int start, int end, int i, int j, ll diff, int node = 1)
{
    if (j < start || end < i) return;
    if (i <= start && end <= j) lazy_tree[node] += diff;
    else {
        int mid = (start + end)/2;
        lazy_update(start, mid, i, j, diff, node*2);
        lazy_update(mid+1, end, i, j, diff, node*2 +1);
    }
}

ll query(int start, int end, int idx, int node = 1)
{
    if (end < idx || idx < start) return 0;
    if (start == end) return lazy_tree[node];
    int mid = (start + end)/2; 
    return (query(start, mid, idx, node*2) + query(mid+1, end, idx, node*2 +1) + lazy_tree[node]);
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
        lazy_tree.resize(size);
        cin >> M;
    }
    int type;
    while (M--) {
        cin >> type;
        if (type == 1) {
            int i, j;
            ll k;
            cin >> i >> j >> k;
            lazy_update(1, N, i, j, k);
        } else {
            int x;
            cin >> x;
            cout << (leaf[x] + query(1, N, x)) << '\n';
        }
    }
}
