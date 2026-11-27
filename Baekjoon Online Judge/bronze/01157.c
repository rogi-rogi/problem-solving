#include <stdio.h>
#define MAX 1000001
#define ALP 26
char str[MAX];
int main(){
    int alphabet[26] ={0,}, max, idx = 0;
    scanf("%s", str);
    for (int i = 0; str[i] != '\0'; i++){
        if(str[i] < 97)
            str[i] += 32;
        alphabet[str[i]-97]++;
    }
    max = alphabet[0];
    for (int i = 1; i < ALP; i++)
        if (alphabet[i] > max) {
            max = alphabet[i];
            idx = i;
        }else if (alphabet[i] == max && alphabet[i] != 0)
            idx = -1;
    putchar(idx == -1 ? '?' : idx + 'A');
}