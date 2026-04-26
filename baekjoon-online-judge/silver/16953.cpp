#include <stdio.h>
#include <queue>
using namespace std;
void bfs(int A, int B){
	queue<pair<int, int> > q;
	q.push(make_pair(A, 1));

	while (!q.empty()){
		long long num = q.front().first;
		int cnt = q.front().second;
		q.pop();

		if (num == B){
			printf("%d", cnt);
			return;
		}

		if (num*2 <= B) q.push(make_pair(num*2, cnt+1));
		if (num*10 +1 <= B) q.push(make_pair(num*10 +1, cnt+1));
	}
	printf("-1");
}
int main(){
	int A, B;
	scanf("%d %d", &A, &B);
	bfs(A, B);
}