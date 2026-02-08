#include <iostream>
#include <vector>
#define SIZE 100000
using namespace std;

int main()
{
    vector<int> dp(SIZE + 1);
    for (int i = 0; i <= SIZE; ++i) dp[i] = i;
    for (int i = 1; i <= SIZE; ++i)
        for (int j = 1; j * j <= i; ++j)
            dp[i] = min(dp[i], dp[i - j * j] + 1);
    int N;
    cin >> N;
    cout << dp[N];
}
