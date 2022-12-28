#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

vector<int> tree;

void update(int start, int end, int idx, int node = 1)
{
    if (idx < start || end < idx) return;
    if (start == end) ++tree[node];
    else {  // start != end && start <= idx <= end
        int mid = (start + end) / 2;
        if (idx <= mid) update(start, mid, idx, node * 2);
        else            update(mid + 1, end, idx, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}

long long query(int start, int end, int i, int j, int node = 1)
{
    if (end < i || j < start) return 0;
    if (i <= start && end <= j) return tree[node];
    int mid = (start + end) / 2;
    return query(start, mid, i, j, node * 2) + query(mid + 1, end, i, j, node * 2 + 1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;
    for (int t = 1; t <= T; ++t) {
        int N, M, K;
        // vector<int> arr[SIZE];
        vector<pair<int, int>> arr;
        {
            cin >> N >> M >> K;
            N = max(N, M);
            arr.resize(K);
            for (int i = 0, v1, v2; i < K; ++i) {
                cin >> v1 >> v2;
                //arr[v1].push_back(v2); 
                arr[i] = {v1, v2}; // Coordinate Compression ver.
            }
            int size = (1 << ((int)ceil(log2(N)) + 1));
            tree.resize(size + 1);
        }
        long long res = 0;
        /*
        for (int i = 1, j; i <= N; ++i) {
            for (j = 0; j < arr[i].size(); ++j) res += query(1, N, arr[i][j] + 1, N);
            for (j = 0; j < arr[i].size(); ++j) update(1, N, arr[i][j]);
        }
        */
        sort(arr.begin(), arr.end());
        for (int i = 0; i < K; ++i) {
            res += query(1, N, arr[i].second + 1, N);
            update(1, N, arr[i].second);
        }
        cout << "Test case " << t << ": " << res << '\n';
        vector<int>().swap(tree);
    }
}

SPDX-FileCopyrightText: © {$year_of_file_creation} {$name_of_copyright_holder} <{$contact}>

SPDX-License-Identifier: {$SPDX_license_name}
