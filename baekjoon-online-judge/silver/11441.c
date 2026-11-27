#include <stdio.h>
int sum[100001];
int main(){
    int N, M, first, last, num;
    scanf("%d", &N);
    for (int i = 1; i <= N; i++){
        scanf("%d", &num);
        sum[i] = sum[i-1] + num;
    }
    scanf("%d", &M);
    while (M--){
        scanf("%d %d", &first, &last);
        printf("%d\n", sum[last] - sum[first-1]);
    }
}