#include <stdio.h>
int main(){
    int N, sq = 1;
    scanf("%d", &N);
    for (; sq <= N; sq *= 2);
    sq /= 2;
    printf("%d", sq == N ? sq : (N-sq)*2);
}