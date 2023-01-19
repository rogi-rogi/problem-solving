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
    int T;
    cin >> T;
    while (T--) {
        int N, P, Q;
        cin >> N >> P >> Q;
        tree.resize(2 << (int)ceil(log2(N)));
        Q += P;
        while (Q--) {
            char type;
            int i;
            cin >> type >> i;
            if (type == 'P') {
                int a;
                cin >> a;
                update(1, N, i, a);
            } else {
                int j;
                cin >> j;
                cout << query(1, N, i, j) << '\n';
            }
        }
        vector<ll>().swap(tree);
    }
}
