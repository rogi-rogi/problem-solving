#include <stdio.h>
typedef struct{
	int x, y;
}Size;
int main(){
	int N;
	scanf("%d", &N);
	Size s[N];
	for (int i = 0; i < N; i++)
		scanf("%d %d", &s[i].x, &s[i].y);
	for (int i = 0; i < N; i++){
		int cnt = 0;
		for (int j = 0; j < N; j++)
			if (s[i].x < s[j].x && s[i].y < s[j].y)
				cnt++;
		printf("%d ", cnt + 1);
	}
}