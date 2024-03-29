#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

typedef struct __Info {
    int max, min;    
}Info;

vector<Info> tree; // <max, min>
vector<int> leaf;

void init(int start, int end, int node = 1)
{
    if (start == end) tree[node] = {leaf[start], leaf[start]};
    else {
        int mid = ((start + end) >> 1);
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
        tree[node] = {max(tree[node*2].max, tree[node*2 +1].max), min(tree[node*2].min, tree[node*2 +1].min)};
    }
}

Info query(int start, int end, int i, int j, int node = 1)
{
    if (j < start || end < i) return {0, 1000000};
    if (i <= start && end <= j) return tree[node];
    int mid = ((start + end) >> 1);
    Info left = query(start, mid, i, j, node*2);
    Info right = query(mid+1, end, i, j, node*2 +1);
    return {max(left.max, right.max), min(left.min, right.min)};
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, Q;
    {
        cin >> N >> Q;
        leaf.resize(N + 1);
        tree.resize(2 << (int)ceil(log2(N)));
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        init(1, N);
    }
    while (Q--) {
        int i, j;
        cin >> i >> j;
        Info info = query(1, N, i, j);
        cout << info.max - info.min << '\n';
    }
}
