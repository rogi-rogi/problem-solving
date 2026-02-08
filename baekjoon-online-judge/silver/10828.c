#include <stdio.h>
#include <string.h>
#define SIZE 10001

int stack[SIZE], top = -1;

int empty(int top)
{
    return top == -1 ? 1 : 0;
}

int main()
{
    int N;
    char cmd[6];
    scanf("%d", &N);
    while (N--) {
        scanf("%s", cmd);
        if (!(strcmp(cmd, "push"))) {
            int n;
            scanf("%d", &n);
            stack[++top] = n;
        } else if (!strcmp(cmd, "pop"))
            printf("%d\n", empty(top) ? -1 : stack[top--]);
        else if (!strcmp(cmd, "size"))
            printf("%d\n", top + 1);
        else if (!strcmp(cmd, "empty"))
            printf("%d\n", empty(top));
        else if (!(strcmp(cmd, "top")))
            printf("%d\n", top == -1 ? -1 : stack[top]);
    }
}
