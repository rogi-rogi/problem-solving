#include <algorithm>
#include <iostream>
#include <vector>
#define MAX 1000000
using namespace std;

vector<int> A(MAX), index_list(MAX), LIS, res;

void print_LIS(int end, int length)
{
    for (int i = end; i >= 0; --i) {
        if (index_list[i] == length) {
            res.push_back(A[i]);
            --length;
        }
    }
    reverse(res.begin(), res.end());
    for (auto r : res) cout << r << ' ';
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i) cin >> A[i];
    for (int i = 0; i < N; ++i) {
        if (i == 0 || A[i] > LIS.back()) {
            index_list[i] = LIS.size();
            LIS.push_back(A[i]);
        } else {
            int idx = lower_bound(LIS.begin(), LIS.end(), A[i]) - LIS.begin();
            LIS[idx] = A[i];
            index_list[i] = idx;
        }
    }
    cout << LIS.size() << '\n';
    print_LIS(N - 1, LIS.size() - 1);
}
