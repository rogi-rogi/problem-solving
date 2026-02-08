#include <iostream>
using namespace std;

double dp[11];

int main()
{
    int Y;
    cin >> dp[0] >> Y;
    for (int i = 1; i <= Y; ++i) {
        dp[i] = (dp[i - 1] * 1.05);
        if (i >= 3) dp[i] = max(dp[i], dp[i - 3] * 1.2);
        if (i >= 5) dp[i] = max(dp[i], dp[i - 5] * 1.35);
        dp[i] = (int)dp[i];
    }
    cout << dp[Y];
}
