#include <cmath>
#include <iostream>
#include <vector>

#define L (node << 1)
#define R (L + 1)
using namespace std;
typedef long long ll;

vector<pair<ll, int>> tree;
vector<ll> leaf;

void init(int i, int j, int node = 1)
{
    if (i == j) tree[node] = {leaf[i], i};
    else {
        int mid = (i + j)/2;
        init(i, mid, L);
        init(mid+1, j, R);
        int idx = (leaf[tree[L].second] < leaf[tree[R].second] ? tree[L].second : tree[R].second);
        tree[node] = {tree[L].first + tree[R].first, idx};
    }
}

pair<ll, int> query(int i, int j, int start, int end, int node = 1)
{
    if (end < i || j < start) return {0, 0};
    if (start <= i && j <= end) return tree[node];
    int mid = (i + j) >> 1;
    pair<ll, int> left = query(i, mid, start, end, L);
    pair<ll, int> right = query(mid+1, j, start, end, R);
    int idx = (leaf[left.second] < leaf[right.second] ? left.second : right.second);
    return {left.first + right.first, idx};
}

ll divide(int i, int j, int N)
{
    if (i == j) return leaf[i] * leaf[i];
    pair<ll, int> self = query(1, N, i, j);
    int mid = (i + j) >> 1;
    ll res = self.first * leaf[self.second];
    if (i < self.second)
        res = max(res, divide(i, self.second - 1, N));
    if (self.second < j)
        res = max(res, divide(self.second + 1, j, N));
    return res;
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    {
        cin >> N;
        leaf.resize(N + 1);
        leaf[0] = 1000001;
        for (int i = 1; i <= N; ++i) cin >> leaf[i];
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size);
        init(1, N);
    }
    cout << divide(1, N, N);
}
