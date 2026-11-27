#include <stdio.h>
int main() {
    char str[80], N;
    scanf("%d", &N);
    while (N--) {
        int temp = 0, sum = 0;
        scanf("%s", &str);
        for (int i = 0; str[i] != '\0'; i++)
            (str[i] == 'O') ? sum += ++temp : (temp = 0);
        printf("%d\n", sum);
    }
}