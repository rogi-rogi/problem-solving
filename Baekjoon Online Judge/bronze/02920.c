#include <stdio.h>
#include <string.h>
int main(){
    char str[17];
    gets(str);
    if (!strcmp(str,"1 2 3 4 5 6 7 8"))
        puts("ascending");
    else if (!strcmp(str, "8 7 6 5 4 3 2 1"))
        puts("descending");
    else
        puts("mixed");
}