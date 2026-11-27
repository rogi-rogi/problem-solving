#include <stdio.h>
#include <string.h>
#define MAX 10001
int front = MAX/2 - 1, rear = MAX/2;
int empty(){
    return front + 1 == rear;
}
int main(){
    int deque[MAX], N, n;
    char instruction[11];
    scanf("%d", &N);
    while (N--){
        scanf("%s", instruction);

        if (!(strcmp(instruction, "push_front"))){
            scanf("%d", &n);
            deque[front--] = n;
        }else if (!strcmp(instruction, "push_back")){
        	scanf("%d", &n);
        	deque[rear++] = n;
		}else if (!strcmp(instruction, "pop_front")){
			printf("%d\n", empty() ? -1 : deque[++front]);
		}else if (!strcmp(instruction, "pop_back")){
			printf("%d\n", empty() ? -1 : deque[--rear]);
		}else if (!strcmp(instruction, "size"))
            printf("%d\n", rear - front - 1);
        else if (!strcmp(instruction, "empty"))
            printf("%d\n", empty());
        else if (!(strcmp(instruction, "front")))
            printf("%d\n", empty() ? -1 : deque[front+1]);
        else if (!(strcmp(instruction, "back")))
            printf("%d\n", empty() ? -1 : deque[rear-1]);
    }
}