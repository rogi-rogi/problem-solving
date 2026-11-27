#include <stdio.h>
int main(){
    int N, cnt = 0;
    scanf("%d",&N);
    for(int i = 1 ; i <= N; i++) {
        if(i%125 == 0) cnt += 3;
        else if(i%25 == 0) cnt += 2;
        else if(i%5 == 0) cnt += 1;
    }
    printf("%d", cnt);
}