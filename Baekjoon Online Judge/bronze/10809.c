#include <stdio.h>
int main(){
	char str[101], cnt[26] = { 0, };
	scanf("%s", str);
	for (int i = 0; str[i] != '\0'; i++)
		if (!cnt[str[i] - 'a'])
			cnt[str[i] - 'a'] = i + 1;
	for (int i = 0; i < 26; i++)
		printf("%d ", cnt[i] - 1);
}