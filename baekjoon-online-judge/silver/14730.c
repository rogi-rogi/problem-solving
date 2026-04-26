#include <stdio.h>
int main(){
    int N, n1, n2, result = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; i++){
        scanf("%d %d", &n1, &n2);
        result += n1*n2;
    }
    printf("%d", result);
}