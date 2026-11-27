#include <stdio.h>
#include <string.h>
int main(){
    char str[1000001];
    gets(str);
    int cnt = 0, len = strlen(str);

    if (len == 1 && str[0] == ' '){
        cnt = -1;
    }else
        for(int i = 1; i < len-1; i++)
            if(str[i] == ' ')
                cnt++;
    printf("%d\n", cnt+1);
}