#include <iostream>
using namespace std;

long long dp[36] = {1, };

long long t(int n)
{
    long long sum = 0;
    for (int i = 0; i <= n - 1; ++i) sum += dp[i] * dp[n - i - 1];
    return sum;
} 

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) dp[i] = t(i);
    cout << dp[n];
}
