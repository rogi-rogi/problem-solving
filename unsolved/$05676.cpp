#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

vector<int> tree, leaf;

int get_sign(int num) { return (num == 0 ? 0 : (num > 0 ? 1 : -1)); }

void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = leaf[start];
    else {
        int mid = ((start + end) >> 1);
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
        tree[node] = tree[node*2] * tree[node*2 +1];
    }
}

void update(int start, int end, int idx, int sign, int node = 1)
{
    if (end < idx || idx < start) return;
    if (start == end) tree[node] = sign;
    else {
        int mid = ((start + end) >> 1);
        update(start, mid, idx, sign, node*2);
        update(mid+1, end, idx, sign, node*2 +1);
        tree[node] = tree[node*2] * tree[node*2 +1];
    }
}

int query(int start, int end, int i, int j, int node = 1)
{
    if (j < start || end < i) return 1;
    if (i <= start && end <= j) return tree[node];
    int mid = ((start + end) >> 1);
    return query(start, mid, i, j, node*2) * query(mid+1, end, i, j, node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, K;
    while (cin >> N >> K) {
        leaf.resize(N + 1);
        tree.resize(2 << (int)ceil(log2(N)), 1);
        for (int i = 1, val; i <= N; ++i) {
            cin >> val;
            leaf[i] = get_sign(val);
        }
        init(1, N);
        while (K--) {
            char type;
            int i;
            cin >> type >> i;
            if (type == 'C') {
                int V;
                cin >> V;
                update(1, N, i, get_sign(V));
            } else {
                int j;
                cin >> j;
                int res = query(1, N, i, j);
                cout << (res == 0 ? '0' : (res > 0 ? '+' : '-'));
            }
        }
        vector<int>().swap(tree);
        vector<int>().swap(leaf);
        cout << '\n';
    }
}
