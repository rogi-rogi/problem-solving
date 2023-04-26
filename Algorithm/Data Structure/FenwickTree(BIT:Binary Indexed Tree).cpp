#include <cstdio>
#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

vector<ll> tree, arr;

ll query(int i)
{
    ll res = 0;
    /*
    while (i) {
        res += tree[i]; 
        i -= (i & -i);
    }
    */
    for (; i; i -= (i & -i)) res += tree[i];
    return res;
}

void update(int i, ll diff)
{
    /*
    while (i < tree.size()) {
        tree[i] += diff;
        i += (i & -i);
    }
    */
    for (; i < tree.size(); i += (i & -i)) tree[i] += diff;
}

/*
'prefix_sum(arr[i])' is mean get the prefix sum of arr[1] ~ arr[i]
prefix_sum(arr[i]) = tree[i] + prefix_sum(tree[i - L[i]])
L[i] = i & -i, i를 2진수로 나타낼 때, bit중 가장 마지막에 1만 남은 값

ex)
prefix_sum(arr[13]) = sum(arr[1] ~ arr[13])

13 = 1101, L[13] = 0001 = 1
prefix_sum(arr[13]) = tree[13] + prefix_sum(tree[13 - 1])

12 = 1100, L[12] = 0100 = 4
prefix_sum(arr[12]) = tree[12] + prefix_sum(tree[12 - 4])

8 = 1000, L[8] = 1000 = 0
prefix_sum(arr[8]) = tree[8]

*/

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, Q;
    {
        cin >> N >> Q;
        arr.resize(N + 1);
        tree.resize(N + 1);
        for (int i = 1; i <= N; ++i) {
            cin >> arr[i];
            update(i, arr[i]);
        }
    }
    int type;
    while (Q--) {
        cin >> type;
        if (type == 1) {           // Update Fenwick Tree & arr
            int idx;
            ll val;
            cin >> idx >> val;
            ll diff = val - arr[idx];
            arr[idx] = val;
            update(idx, diff);
        } else { // type == 2,        Query to get the prefix sum of arr[1] ~ arr[i]
            int i, j;
            cin >> i >> j;
            cout << query(j) - query(i - 1) << '\n'; // arr[i] ~ arr[j] = arr[j] - arr[i - 1]
        }
    }
}
