#include <stdio.h>

int main() {
    char str[1001];
    gets(str);
    putchar(str[0]);
    for (int i = 1; str[i] != '\0'; ++i) {
        if (str[i] == str[i - 1]) continue;
        putchar(str[i]);
    }
}
