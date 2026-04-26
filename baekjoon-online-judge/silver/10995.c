#include <stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    for (int i = 0; i < N; i++){
        for (int j = 0; j < 2*N; j++)
            putchar((i+j)%2 ? 32 : '*');
        putchar(10);
    }
}