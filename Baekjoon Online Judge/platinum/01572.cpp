#include <cmath>
#include <vector>
#include <iostream>

#define SIZE 65537

using namespace std;
typedef long long ll;

vector<int> tree(1 << ((int)ceil(log2(SIZE))+ 1)), leaf;

void update(int start, int end, int idx, int val, int node = 1)
{
    if (end < idx || idx < start) return;
    tree[node] += val;
    if (start == end) return;
    int mid = (start + end)/2;
    update(start, mid, idx, val, node*2);
    update(mid+1, end, idx, val, node*2 +1);
}

ll query(int start, int end, int idx, int node = 1)
{
    if (start == end) return start;
    int mid = (start + end)/2;
    if (tree[node*2] >= idx) return query(start, mid, idx, node*2);
    else return query(mid+1, end, idx - tree[node*2], node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, K;
    cin >> N >> K;
    leaf.resize(N + 1);
    ll res = 0;
    for (int i = 1; i <= N; ++i) {
        cin >> leaf[i];
        update(0, SIZE, leaf[i], 1);
        if (i >= K) {
            res += query(0, SIZE, (K + 1) / 2);
            update(0, SIZE, leaf[i - K + 1], -1);
        }
    }
    cout << res;
}
