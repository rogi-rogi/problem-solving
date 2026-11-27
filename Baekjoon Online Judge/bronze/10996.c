#include <stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    for (int i = 0; i < 2*N; i++){
        for (int j = 0; j < N; j++)
            putchar((i+j)%2 ? 32 : '*');
        putchar(10);
    }
}