#include <stdio.h>
int main() {
    int num, max = 0, cnt;
    for (int i = 1; i <= 9; i++) {
        scanf("%d", &num);
        if (num > max) {
            max = num;
            cnt = i;
        }
    }
    printf("%d\n%d", max, cnt);
}