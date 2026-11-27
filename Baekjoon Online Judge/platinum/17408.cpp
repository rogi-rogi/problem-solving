#include <cmath>
#include <iostream>
#include <vector>

#define LEFT (node << 1)
#define RIGHT (node << 1 | 1)

using namespace std;
typedef pair<int, int> pii;

vector<pii> tree;
vector<int> leaf;


pii get_max_pair(const pii &left, const pii &right)
{
    if (left.first >= right.first)
        return {left.first, (left.second >= right.first ? left.second : right.first)};
    return {right.first, (left.first >= right.second ? left.first : right.second)};
}

void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = {leaf[start], 0};
    else {
        int mid = (start + end)/2;
        init(start, mid, LEFT);
        init(mid+1, end, RIGHT);
        tree[node] = get_max_pair(tree[LEFT], tree[RIGHT]);
    }
}

void update(int start, int end, int idx, int val, int node = 1)
{
    if (end < idx || idx < start) return;
    if (start == end) tree[node].first = (leaf[idx] = val), 0;
    else {
        int mid = (start + end)/2;
        update(start, mid, idx, val, LEFT);
        update(mid+1, end, idx, val, RIGHT);
        tree[node] = get_max_pair(tree[LEFT], tree[RIGHT]);
    }
}

pii query(int start, int end, int i, int j, int node = 1)
{
    if (j < start || end < i) return {0, 0};
    if (i <= start && end <= j) return tree[node];
    int mid = (start + end)/2;
    return get_max_pair(query(start, mid, i, j, LEFT), query(mid+1, end, i, j, RIGHT));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    {   // leaf node input & segment tree initialization
        cin >> N;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
        init(1, N);
    }
    int type, Q;
    cin >> Q;
    while (Q--) {
        cin >> type;
        if (type == 1) {
            int idx, val;
            cin >> idx >> val;
            update(1, N, idx, val);
        } else { // type == 2
            int i, j;
            cin >> i >> j;
            pii res = query(1, N, i, j);
            cout << res.first + res.second << '\n';
        }
    }
}
