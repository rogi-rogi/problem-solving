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
    while (1) {
        int N;
        map<string, int> edges;
        vector<ll> arr;
        {
            cin >> N;
            if (N == 0) break;
            arr.resize(N + 1);
            string v1, v2;
            for (int i = 1; i <= N; ++i) {
                cin >> v1;
                edges.insert({v1, i});
            }
            for (int i = 1; i <= N; ++i) {
                cin >> v2;
                arr[i] = edges[v2];
            }
            tree.resize(N + 1);
        }
        ll res = 0;
        for (int i = 1; i <= N; ++i) {
            res += (arr[i] - 1) - query(arr[i]);
            update(arr[i]);
        }
        cout << res << '\n';
        vector<int>().swap(tree);
    }
}
