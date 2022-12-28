#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

vector<int> tree;

void update(int left, int right, int idx, int node = 1)
{
    if (idx < left || right < idx) return;
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
    vector<pair<int, int>> arr;
    {
        cin >> N >> M;
        arr.resize(M);
        for (int i = 0, v1, v2; i < M; ++i) {
            cin >> v1 >> v2;
            arr[i] = {v1, v2};
        }
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size + 1);
    }
    long long res = 0;
    sort(arr.begin(), arr.end());
    for (int i = 0; i < M; ++i) {
        res += query(1, N, arr[i].second + 1, N);
        update(1, N, arr[i].second);
    }
    cout << res;
}
