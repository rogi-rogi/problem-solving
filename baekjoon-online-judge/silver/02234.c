#include <stdio.h>
#include <stdbool.h>
#include <memory.h>
#define MAX 50
int n, m, graph[MAX][MAX], rear;
bool visited[MAX][MAX];
typedef struct{
	int x, y;
}Point;
Point queue[MAX*MAX], d[4] = {{0,-1}, {-1,0}, {0,1}, {1,0}};
void push(int i, int j){
	queue[rear].x = i;
	queue[rear++].y = j;
}
int bfs(int x, int y){
	int area = 1, front = 0;
	visited[x][y] = 1, rear = 0;
	push(x, y);

	while (front != rear){
		x = queue[front].x;
		y = queue[front++].y;

		for (int dir = 0, bit = 1; dir < 4; dir++){
			if (!(graph[x][y] & bit)){
				int tx = x + d[dir].x, ty = y + d[dir].y;

				if (tx >= 0 && ty >= 0 && tx < m && ty < n)
					if (!visited[tx][ty]){
						visited[tx][ty] = 1;
						push(tx, ty);
						area++;
					}
			}
			bit <<= 1;
		}
	}
	return area;
}
int main(){
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &graph[i][j]);

	int cnt = 0, max_area = 0;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			if (!visited[i][j]){
				int temp = bfs(i, j);
				max_area < temp && (max_area = temp);
				cnt++;
			}
	printf("%d\n%d\n", cnt, max_area);
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			for (int dir = 1; dir <= 8; dir <<= 1)
				if (graph[i][j] & dir){
					memset(visited, 0, sizeof(visited));
					graph[i][j] -= dir;
					int temp = bfs(i, j);
					max_area < temp && (max_area = temp);
					graph[i][j] += dir;
				}
	printf("%d", max_area);
}