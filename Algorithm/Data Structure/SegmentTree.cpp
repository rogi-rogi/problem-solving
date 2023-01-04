#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<ll> tree, leaf;

void init(int start, int end, int node = 1) // node = 1 is root node
{
    if (start == end) tree[node] = leaf[start]; // or leaf[end]
    else {
        int mid = (start + end)/2;
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

void update(int start, int end, int idx, ll val, int node = 1)
{
    if (end < idx || idx < start) return; // (arr[L1] ~ arr[R1]) < (arr[i] ~ arr[j]) < (arr[L2] ~ arr[R2])
    if (start == end) tree[node] = (leaf[idx] = val);
    else {
        int mid = (start + end)/2;
        update(start, mid, idx, val, node*2);
        update(mid+1, end, idx, val, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

ll query(int start, int end, int i, int j, int node = 1)
{
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
    {   // leaf node input & segment tree initialization
        cin >> N >> Q;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
        init(1, N);
    }
    int type;
    while (Q--) {
        cin >> type;
        if (type == 1) {           // Update segment tree & leaf node : "arr[idx] = val"
            int idx;
            ll val;
            cin >> idx >> val;
            update(1, N, idx, val);
        } else { // type == 2,        Query to get the sub sum of arr[i] ~ arr[j]
            int i, j;
            cin >> i >> j;
            cout << "sub sum of arr[i] ~ arr[j] is : " << query(1, N, i, j)<< '\n';
        }
    }
}
