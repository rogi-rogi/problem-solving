#include <stdio.h>

int main()
{
    int N, cnt;
    scanf("%d", &N);
    cnt = N / 5;
    if (N % 5)
        for (; cnt >= 0; cnt--)
            if ((N - 5 * cnt) % 3 == 0) {
                cnt += (N - 5 * cnt) / 3;
                break;
            }
    printf("%d", cnt);
}
