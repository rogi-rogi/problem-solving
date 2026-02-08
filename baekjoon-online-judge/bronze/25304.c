#include <stdio.h>

int main()
{
    int X, N;
    scanf("%d\n%d", &X, &N);
    while (N--) {
        int a, b;
        scanf("%d %d", &a, &b);
        X -= a * b;
    }
    puts(X == 0 ? "Yes" : "No");
}
