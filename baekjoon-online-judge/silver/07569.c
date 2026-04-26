#include <stdio.h>
#define MAX 101
int box[MAX][MAX][MAX], M, N, H, rear;
int dx[6] = {-1, 1};
int dy[6] = {0, 0, -1, 1};
int dz[6] = {0, 0, 0, 0, -1, 1};
typedef struct{
    int x, y, z;
}Queue;
Queue q[MAX*MAX*MAX];
void push(int i, int j, int k){
	q[rear].x = i;
	q[rear].y = j;
	q[rear++].z = k;
}
int bfs(int empty){
	if (!empty) return 0;
    int x, y, z, px, py, pz, front = 0;
    while (front != rear){
        x = q[front].x;
        y = q[front].y;
        z = q[front++].z;
        for (int i = 0; i < 6; i++){
            int tx = x+dx[i], ty = y+dy[i], tz = z+dz[i];

            if (tx > 0 && ty > 0 && tz > 0 && tx <= N && ty <= M && tz <= H)
                if (!box[tx][ty][tz]){
                	box[tx][ty][tz] = box[x][y][z] + 1;
                    push(tx, ty, tz);
                    empty--;
                    px = tx, py = ty, pz = tz;
                }
        }
    }
    return empty > 0 ? -1 : box[px][py][pz]-1;
}
int main(){
	int empty = 0;
	scanf("%d %d %d", &M, &N, &H);
	for (int k = 1; k <= H; k++)
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++){
				scanf("%d", &box[i][j][k]);
				if (!box[i][j][k]) empty++;
				else if (box[i][j][k] == 1) push(i, j, k);
			}
	printf("%d", bfs(empty));
}