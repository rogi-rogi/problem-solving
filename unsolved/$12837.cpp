#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> tree;

void update(int start, int end, int idx, int val, int node = 1)
{
    if (end < idx || idx < start) return;
    if (start == end) tree[node] += val;
    else {
        int mid = ((start + end) >> 1);
        update(start, mid, idx, val, node*2);
        update(mid+1, end, idx, val, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

ll query(int start, int end, int i, int j, int node = 1)
{
    if (j < start || end < i) return 0;
    if (i <= start && end <= j) return tree[node];
    int mid = ((start + end) >> 1);
    return query(start, mid, i, j, node*2) + query(mid+1, end, i, j, node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, Q;
    {
        cin >> N >> Q;
        tree.resize(2 << (int)ceil(log2(N)));
    }
    while (Q--) {
        int type, p;
        cin >> type >> p;
        if (type == 1) {
            int x;
            cin >> x;
            update(1, N, p, x);
        } else {
            int q;
            cin >> q;
            cout << query(1, N, p, q) << '\n';
        }
    }
}
