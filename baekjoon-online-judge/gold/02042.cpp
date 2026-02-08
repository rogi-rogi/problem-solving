#include <cmath>
#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

vector<ll> tree, leaf;

void init(int left, int right, int node = 1)
{
    if (left == right) tree[node] = leaf[left];
    else {
        int mid = (left + right)/2;
        init(left, mid, node*2);
        init(mid+1, right, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

void update(int left, int right, int idx, ll val, int node = 1)
{
    if (right < idx || idx < left) return;
    if (left == right) tree[node] = (leaf[idx] = val);
    else {
        int mid = (left + right)/2;
        update(left, mid, idx, val, node*2);
        update(mid+1, right, idx, val, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

ll query(int left, int right, int i, int j, int node = 1)
{
    if (j < left || right < i) return 0;
    if (i <= left && right <= j) return tree[node];
    int mid = (left + right)/2;
    return query(left, mid, i, j, node*2) + query(mid+1, right, i, j, node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M, K;
    {
        cin >> N >> M >> K;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size + 1);
        init(1, N);
    }
    for (int i = 0, a, b; i < M + K; ++i) {
        ll c;
        cin >> a >> b >> c;
        if (a == 1) update(1, N, b, c);
        else cout << query(1, N, b, c) << '\n';
    }
}
