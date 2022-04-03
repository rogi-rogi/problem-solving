#include <stdio.h>

int fibo(int n)
{
    int fiboNum[2] = {0, 1};
    for (int i = 1 ; i < n; ++i)
        fiboNum[(i + 1) % 2] = fiboNum[i % 2] + fiboNum[(i - 1) % 2];
    return fiboNum[n % 2];
}

int main()
{
    int n;
    scanf("%d", &n);
    printf("%d", fibo(n));
}
