#include <stdio.h>

int main()
{
    int P;
    scanf("%d", &P);
    while (P--) {
        int N, M;
        scanf("%d %d", &N, &M);
        
        int dp[2] = {0, 1}; // toggling
        int period = 0;
        do {
            int next_fibo = (dp[0] + dp[1]) % M;
            { // swap
                dp[0] = dp[1];
                dp[1] = next_fibo;
            }
            ++period;
        } while (dp[0] != 0 || dp[1] != 1);
        
        printf("%d %d\n", N, period);
    }
}
