#include <algorithm>
#include <iostream>
using namespace std;

double dp[10001] = {1.0, };

int main()
{
    int N;
    cin >> N;
    for (int i = 1; i <= N; ++i) {
        cin >> dp[i];
    }
    double res = dp[1];
    for (int i = 1; i <= N; ++i) dp[i] = max(dp[i], dp[i] * dp[i - 1]);
    for (int i = 2; i <= N; ++i) res = max(res, dp[i]);
    printf("%.3lf", res);
}
