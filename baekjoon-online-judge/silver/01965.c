#include <stdio.h>
int main(){
    int N, max = 0, length;
    scanf("%d", &N);
    int arr[N], dp[N];
    for (int i = 0; i < N; i++){
        scanf("%d", &arr[i]);
        length = 0;
        for (int j = 0; j < i; j++)
            if (arr[j] < arr[i])
                length < dp[j] && (length = dp[j]);
        dp[i] = length + 1;
       	max < dp[i] && (max = dp[i]);
    }
    printf("%d", max);
}