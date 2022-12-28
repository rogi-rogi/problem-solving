#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

vector<int> tree;

void update(int i) { for (; i < tree.size(); i += (i & -i)) tree[i] += 1; }

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
        int size = (1 << ((int)ceil(log2(N)) + 1));
        tree.resize(size + 1);
    }
    
    ll res = 0;
    sort(arr.begin(), arr.end());
    for (int i = 0; i < E; ++i) {
        res += query(N) - query(arr[i].second);
        
        update(arr[i].second);
    }
    cout << res;
}
