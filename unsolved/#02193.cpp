#include <iostream>
using namespace std;

int main()
{
    int N;
    cin >> N;
    long long dp[2] = {1, 1};
    for (int t = 3; t <= N; ++t) dp[t % 2] += dp[(t + 1) % 2];
    cout << dp[N % 2];
}
