#include <stdio.h>
#define F 15
#define NO 14
int main(){
	int T, k, n, arr[F][NO];
	for (int i = 0; i < F; i++)
		for (int j = 0; j < NO; j++)
			arr[i][j] = ((i&&j) ? arr[i][j-1] + arr[i-1][j] : (i?0:i)+j+1);

	scanf("%d", &T);
	while (T--){
		scanf("%d %d", &k, &n);
		printf("%d\n", arr[k][n-1]);
	}
}