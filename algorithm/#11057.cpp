#include <algorithm>
#include <iostream>
#define MOD 10007
#define SIZE 10
using namespace std;

int main()
{
    int N;
    cin >> N;
    int dp[2][SIZE];
    fill(&dp[0][0], &dp[1][SIZE], 1);
    for (int t = 1; t < N; ++t)
        for (int i = 1; i < SIZE; ++i)
            dp[t % 2][i] = (dp[t % 2][i - 1] + dp[(t + 1) % 2][i]) % MOD;
    int sum = 1;
    for (int i = 1; i < SIZE; ++i) sum += dp[(N - 1) % 2][i];
    cout << sum % MOD;
}
