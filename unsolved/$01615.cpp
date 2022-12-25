#include <cmath>
#include <iostream>
#include <vector>

#define SIZE 2001

using namespace std;
typedef long long ll;

vector<int> tree, arr[SIZE];

void update(int left, int right, int idx, int node = 1)
{
    if (left == right) ++tree[node];
    else {
        int mid = (left + right)/2;
        if (idx <= mid) update(left, mid, idx, node*2);
        else            update(mid +1, right, idx, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

ll query(int left, int right, int i, int j, int node = 1)
{
    if (right < i || j < left) return 0;
    if (i <= left && right <= j) return tree[node];
    int mid = (left + right)/2;
    return query(left, mid, i, j, node*2) + query(mid +1, right, i, j, node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    {
        cin >> N >> M;
        for (int i = 0, to, from; i < M; ++i) {
            cin >> to >> from;
            arr[to].push_back(from);
        }
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size + 1);
    }
    long long res = 0;
    for (int i = 1, j; i <= N; ++i) {
        for (j = 0; j < arr[i].size(); ++j) res += query(1, N, arr[i][j] +1, N);
        for (j = 0; j < arr[i].size(); ++j) update(1, N, arr[i][j]);
    }
    cout << res;
}
