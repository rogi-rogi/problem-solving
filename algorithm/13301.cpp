#include <iostream>
using namespace std;

int main()
{
    long long dp[2] = {0, 1}; // {2, 4};
    int N;
    cin >> N;
    for (int i = 2; i <= N; ++i)
        dp[i % 2] = dp[i % 2] + dp[(i + 1) % 2];
    cout << 4 * dp[N % 2] + 2 * dp[(N + 1) % 2]; // dp[N % 2];
}
