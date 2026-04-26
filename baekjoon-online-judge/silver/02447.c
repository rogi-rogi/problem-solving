#include <stdio.h>
void mark_star(int i, int j, int N){
    if ((i/N)%3 == 1 && (j/N)%3 == 1)
    	putchar(32);
    else
		N/3 == 0 ? (void)putchar('*') : mark_star(i, j, N/3);
}
int main(){
    int N;
    scanf("%d", &N);
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++)
            mark_star(i, j, N);
        putchar(10);
    }
}