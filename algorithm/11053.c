#include <stdio.h>
int main()
{
    int N;
    scanf("%d", &N);
    int arr[N], dp[N], max = 0;
    for (int i = 0; i < N; ++i){
        scanf("%d", &arr[i]);
        int length = 0;
        for (int j = 0; j < i; ++j)
            if (arr[i] > arr[j] && length < dp[j])
                length = dp[j];
        dp[i] = length + 1;
       	max < dp[i] && (max = dp[i]);    
    }
    printf("%d", max);
}
