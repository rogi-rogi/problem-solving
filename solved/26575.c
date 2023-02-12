#include <stdio.h>

int main()
{
    int N;
    scanf("%d", &N);
    while (N--) {
        double A, B, C;
        scanf("%lf %lf %lf", &A, &B, &C);
        printf("$%.2lf\n", A * B * C);
    }
}
