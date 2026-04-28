#include <stdio.h>
#include <stdbool.h>
#include <memory.h>
#include <math.h>
#define MAX 10000
bool cNum[MAX];
int cnt[MAX], queue[MAX];

void bfs(int old, int pw){
	int front = -1, rear = -1, n;
	cnt[queue[++rear] = old] = 0;
	while (front < rear){
		if ((n = queue[++front]) == pw) return;

		for (int i = 0; i < 4; i++){
			int digit[4] = {n/1000, (n/100)%10, (n/10)%10, n%10};

			for (int j = (i ? 0: 1); j < 10; j++)
				if (digit[i] != j){
					digit[i] = j;
					int temp = digit[0]*1000 + digit[1]*100 + digit[2]*10 + digit[3];
					if (!cNum[temp] && cnt[temp] == -1)
						cnt[queue[++rear] = temp] = cnt[n] + 1;
				}
		}
	}
}
int main(){
	int sq = sqrt(MAX);
	for (int i = 2; i <= sq; i++)
		if (!cNum[i])
			for (int j = 2*i; j < MAX; j += i)
				cNum[j] = true;

	int T;
	scanf("%d", &T);
	while (T--){
		memset(cnt, -1, sizeof(cnt));
		int old, pw;
		scanf("%d %d", &old, &pw);
		bfs(old, pw);
		if (cnt[pw] == -1) puts("Impossible");
		else printf("%d\n", cnt[pw]);
	}
}