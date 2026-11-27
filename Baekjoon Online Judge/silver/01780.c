#include <stdio.h>
int paper[2187][2187], I[3];

int all_same_paper(int x, int y, int n){
	int temp = paper[x][y];
	for (int i = x; i < x+n; i++)
		for (int j = y; j < y+n; j++)
			if (paper[i][j] != temp)
				return 0;
	return 1;
}
void division(int x, int y, int n){
	if (all_same_paper(x, y, n))
		I[paper[x][y] + 1]++;
	else
		for (int i = x; i < x+n; i += n/3)
			for (int j = y; j < y+n; j += n/3)
				division(i, j, n/3);
}
int main(){
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N*N; i++)
		scanf("%d", &paper[i/N][i%N]);
	division(0, 0, N);
	printf("%d\n%d\n%d", I[0], I[1], I[2]);
}