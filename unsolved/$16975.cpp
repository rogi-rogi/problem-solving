#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> tree, leaf;

void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = leaf[start];
    else {
        int mid = (start + end)/2;
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
    }
}

void update(int start, int end, int i, int j, ll diff, int node = 1)
{
    if (j < start || end < i) return;
    if (i <= start && end <= j) tree[node] += diff;
    else {
        int mid = (start + end)/2;
        update(start, mid, i, j, diff, node*2);
        update(mid+1, end, i, j, diff, node*2 +1);
    }
}

ll query(int start, int end, int idx, int node = 1)
{
    if (end < idx || idx < start) return 0;
    if (start == end) return tree[node];
    int mid = (start + end)/2; 
    ll left = query(start, mid, idx, node*2);
    ll right = query(mid+1, end, idx, node*2 +1);
    return left + right + (left ? tree[node] : 0) + (right ? tree[node] : 0);
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
        cin >> M;
        init(1, N);
    }
    int type;
    while (M--) {
        cin >> type;
        if (type == 1) {
            int i, j;
            ll k;
            cin >> i >> j >> k;
            update(1, N, i, j, k);
        } else {
            int x;
            cin >> x;
            cout << query(1, N, x) << '\n';
        }
    }
}

