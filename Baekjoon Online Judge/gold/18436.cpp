#include <cmath>
#include <iostream>
#include <utility>
#include <vector>
using namespace std;

vector<pair<int, int>> tree, leaf;    // (cnt_odd, cnt_even)

pair<int, int> operator +(const pair<int, int> &x, const pair<int, int> &y)
{
    return make_pair(x.first + y.first, x.second + y.second);
}

pair<int, int> oddOrEven(int val)
{
    return ((val % 2) ? make_pair(1, 0) : make_pair(0, 1));
}


void init(int start, int end, int node)
{
    if (start == end) tree[node] = leaf[start]; // leaf[end]
    else {
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}

void update(int start, int end, int node, int idx, bool val)
{
    if (start <= idx && idx <= end) {
        if (start == end) tree[node] = (leaf[idx] = oddOrEven(val));
        else {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, idx, val);
            update(mid + 1, end, node * 2 + 1, idx, val);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}

pair<int, int> query(int start, int end, int node, int i, int j)
{
    if (start > j || end < i) return make_pair(0, 0);
    if (i <= start && end <= j) return tree[node];
    else {
        int mid = (start + end) / 2;
        return (query(start, mid, node * 2, i, j) + query(mid + 1, end, node * 2 + 1, i, j));
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    leaf.resize(N + 1);
    for (int i = 1, val; i <= N; ++i) {
        cin >> val;
        leaf[i] = oddOrEven(val);
    }
    int h = (int)ceil(log2(N));
    int size = (1 << (h + 1));
    tree.resize(size + 1);
    init(1, N, 1);
    int M;
    cin >> M;
    while (M--) {
        int mode, l, r;
        cin >> mode >> l >> r;
        if (mode == 1) update(1, N, 1, l, (bool)(r % 2));
        else if (mode == 2) cout << query(1, N, 1, l, r).second << '\n';
        else cout << query(1, N, 1, l, r).first << '\n';
    }
}
