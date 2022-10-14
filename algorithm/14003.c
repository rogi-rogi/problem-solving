#include <algorithm>
#include <iostream>
#include <vector>
#define SIZE 1000000
using namespace std;

vector<int> A(SIZE), index_list(SIZE), dp;

void print_LIS(int length, int idx)
{
    if (idx == -1) return;
    if (index_list[idx] == length) {
        print_LIS(length - 1, idx - 1);
        cout << A[idx] << ' ';
    } else print_LIS(length, idx - 1);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N >> A[0];
    dp.push_back(A[0]);
    index_list.push_back(0);
    int LIS_length = 1;
    for (int i = 1; i < N; ++i) {
        cin >> A[i];
        if (A[i] > dp.back()) {
            dp.push_back(A[i]);
            index_list[i] = LIS_length++;
        } else {
            int idx = lower_bound(dp.begin(), dp.end(), A[i]) - dp.begin();
            dp[idx] = A[i];
            index_list[i] = idx;
        }
    }
    cout << LIS_length << '\n';
    print_LIS(LIS_length - 1, N - 1);
}
