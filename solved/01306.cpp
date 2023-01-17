#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

vector<int> tree, leaf;

void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = leaf[start];
    else {
        int mid = ((start + end) >> 1);
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
        tree[node] = max(tree[node*2], tree[node*2 +1]);
    }
}

int query(int start, int end, int i, int j, int node = 1)
{
    if (j < start || end < i) return 0;
    if (i <= start && end <= j) return tree[node];
    int mid = ((start + end) >> 1);
    return max(query(start, mid, i, j, node*2), query(mid+1, end, i, j, node*2 +1));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    {
        cin >> N >> M;
        leaf.resize(N + 1);
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        tree.resize(1 << ((int)ceil(log2(N)) + 1));
        init(1, N);
    }
    int stop = N - M + 1, gap = M - 1;
    for (int i = M; i <= stop; ++i)
        cout << query(1, N, i - gap, i + gap) << ' ';
}
