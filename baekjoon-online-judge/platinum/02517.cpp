#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

vector<int> tree;
vector<pair<int, int>> leaf;

void update(int i) { for (; i < tree.size(); i += (i & -i)) ++tree[i]; }

int query(int i)
{
    int res = 0;
    for (; i; i -= (i & -i)) res += tree[i];
    return res;
}

bool cmp_idx(const pair<int, int> &a, const pair<int, int> &b) { return (a.second < b.second); }

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    {
        cin >> N;
        leaf.resize(N);
        for (int i = 0, val; i < N; ++i) {
            cin >> val;
            leaf[i] = {val, i + 1};
        }
        sort(leaf.begin(), leaf.end());
        for (int i = 0; i < N; ++i) leaf[i].first = i + 1;
        sort(leaf.begin(), leaf.end(), cmp_idx);
        tree.resize(N + 1);
    }
    for (int i = 0; i < N; ++i) {
        int val = leaf[i].first;
        cout << (i + 1) - query(val - 1) << '\n';
        update(val);
    }
}
