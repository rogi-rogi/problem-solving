#include <stdio.h>
#include <memory.h>
char arr[1023][2045], N;
void mark_star(int x, int y, int n){
	if (n == 1) arr[x][y] = '*';
	else {
		int height = (1<<n) -1, width = (1<<(n+1))-3;
		for (int i = 0; i < width; i++)
			arr[x+(n%2 ? height-1 : 0)][y+i] = '*';

		for (int i = 0; i < height; i++){
			if (n%2)
				arr[x+i][y+width/2-i] = arr[x+i][y+width/2+i] = '*';
			else
				arr[x+i][y+i] = arr[x+i][y+width-i-1] = '*';
		}

		mark_star(x+(n%2 ? height/2 : 1), y+(1<<(n-1)), n-1);
	}
}
int main(){
	scanf("%d", &N);
	int height = (1<<N)-1, width = (1<<N+1)-3;
	memset(arr, 32, sizeof(arr));
	mark_star(0, 0, N);
	for (int i = -height/2; i < height/2 + height%2; i++){
		for (int j = 0; j <= width/4*3 + (N%2 ? i : -i); j++)
			putchar(arr[i+height/2][j]);
		putchar(10);
	}
}