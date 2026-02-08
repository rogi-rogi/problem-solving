#include <stdio.h>
#include <string.h>
#define MAX 10001

int queue[MAX], front = -1, rear = -1;
int empty() { return front == rear; }

int main()
{
    int N, n;
    char cmd[6];
    scanf("%d", &N);
    while (N--) {
        scanf("%s", cmd);
        if (!(strcmp(cmd, "push"))) {
            scanf("%d", &n);
            queue[++front] = n;
        }
        else if (!strcmp(cmd, "pop"))   printf("%d\n", empty() ? -1 : queue[++rear]);
        else if (!strcmp(cmd, "size"))  printf("%d\n", front - rear);
        else if (!strcmp(cmd, "empty")) printf("%d\n", empty());
        else if (!strcmp(cmd, "front")) printf("%d\n", empty() ? -1 : queue[rear + 1]);
        else if (!strcmp(cmd, "back"))  printf("%d\n", empty() ? -1 : queue[front]);
    }
}
