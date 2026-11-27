#include <bits/stdc++.h>
using namespace std;

int main() {
    // Init
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;

    // Input
    scanf("%d", &N);
    int arr[N + 1];
    for (int i = 1; i <= N; ++i)
        scanf("%d", &arr[i]);

    // Solve
    int dp[N + 1] = {
        0, 
        arr[1], 
        arr[2] + arr[1], 
        arr[3] + max(arr[2], arr[1]), 
    };

    for (int i = 4; i <= N; ++i) 
        dp[i] = arr[i] + max(dp[i - 2], arr[i - 1] + dp[i - 3]);
    
    // Output
    printf("%d", dp[N]);
}
