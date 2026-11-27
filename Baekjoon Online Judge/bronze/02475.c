#include <stdio.h>
int main(){
    int num[5], result = 0;
    for (int i = 0; i < 5; i++)
        scanf("%d", &num[i]);
    for (int i = 0; i < 5; i++)
        result += num[i]*num[i];
    printf("%d", result%10);
}