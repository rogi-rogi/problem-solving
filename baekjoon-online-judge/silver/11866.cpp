#include <iostream>
#include <queue>
using namespace std;
int main(){
	int N, K, cnt = 1;
	cin >> N >> K;
	queue<int> Q;
	for (int i = 1; i <= N; i++)
		Q.push(i);

	cout << "<";
	while (!Q.empty()){
		if (cnt % K){
			int n = Q.front();
			Q.pop();
			Q.push(n);
		}else {
			cout << Q.front();
			Q.pop();
			cout << (Q.empty() ? ">" : ", ");
		}
		cnt++;
	}
}