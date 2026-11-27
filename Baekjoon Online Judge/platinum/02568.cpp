#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> A;
vector<int> index_list(100000), LIS, res;

void print_LIS(int end, int length)
{
    for (int i = end; i >= 0; --i) {
        if (index_list[i] != length) res.push_back(A[i].first);
        else --length;
    }
    sort(res.begin(), res.end());
    for (auto r : res) cout << r << '\n';
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    for (int i = 0, from, to; i < N; ++i) {
        cin >> from >> to;
        A.push_back(make_pair(from, to));
    }
    sort(A.begin(), A.end());
    for (int i = 0; i < N; ++i) {
        if (i == 0 || A[i].second > LIS.back()) {
            index_list[i] = LIS.size();
            LIS.push_back(A[i].second);
        } else {
            int idx = lower_bound(LIS.begin(), LIS.end(), A[i].second) - LIS.begin();
            LIS[idx] = A[i].second;
            index_list[i] = idx;
        }
    }
    cout << N - LIS.size() << '\n';
    print_LIS(N - 1, LIS.size() - 1);
}
