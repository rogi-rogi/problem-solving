#include <stdio.h>
#include <math.h>
#define MAX 1000000
int arr[MAX];
int main(){
    int idx = 3;
    for (int i = 0; i < MAX; i++)
        arr[i] = i+1;
    for (int i = 2; i <= sqrt(MAX); i++)
        if (arr[i-1])
            for (int j = i*2; j <= MAX; j += i)
                arr[j-1] = 0;
    arr[0] = 0;
    int M, N, prime = 0, num;
    scanf("%d %d", &M, &N);
    for (int i = M-1; i < N; i++){
    	if (arr[i])
    		printf("%d\n", arr[i]);
    }
}