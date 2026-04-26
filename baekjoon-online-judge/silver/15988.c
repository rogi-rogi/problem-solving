#include <stdio.h>
const int MOD = 1e9+9;
int dp[1000001] = {1, 2, 4};
int main(){
    for (int i = 3; i < 1000001; i++)
        dp[i] = ((dp[i-1]+dp[i-2])%MOD +dp[i-3]) %MOD;

    int N, T;
    for (scanf("%d", &T); T--;){
        scanf("%d", &N);
        printf("%d\n", dp[N-1]);
    }
}