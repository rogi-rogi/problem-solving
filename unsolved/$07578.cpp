#include <cmath>
#include <iostream>
#include <map>
#include <vector>
using namespace std;
typedef long long ll;

vector<int> tree;

void update(int i) { for (; i < tree.size(); i += (i & -i)) ++tree[i]; }

ll query(int i)
{
    ll res = 0;
    for (; i; i -= (i & -i)) res += tree[i];
    return res;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    map<int, int> edges;
    vector<ll> arr;
    {
        cin >> N;
        arr.resize(N + 1);
        for (int i = 1, v1; i <= N; ++i) {
            cin >> v1;
            edges.insert({v1, i});
        }
        for (int i = 1, v2; i <= N; ++i) {
            cin >> v2;
            arr[i] = edges[v2];
        }
        tree.resize(N + 1);
    }
    ll res = 0;
    for (int i = 1; i <= N; ++i) {
        res += query(N) - query(arr[i]);
        update(arr[i]);
    }
    cout << res;
    vector<int>().swap(tree);
}
