#include <algorithm>
#include <cmath>
#include <iostream>
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
    int N, E;
    cin >> N >> E;
    vector<pair<int, int>> arr(E);
    {
        for (int i = 0, v1, v2; i < E; ++i) {
            cin >> v1 >> v2;
            arr[i] = {v1, v2};
        }
        tree.resize(N + 1);
    }
    
    ll res = 0;
    sort(arr.begin(), arr.end());
    for (int i = 0; i < E; ++i) {
        res += query(N) - query(arr[i].second); // if "form : arr[v1] = v2", res += (arr[i] - 1) - query(arr[i]);
        update(arr[i].second);
    }
    cout << res;
}
