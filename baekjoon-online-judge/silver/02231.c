#include <stdio.h>
int selfNum(int n){
    int cnt = 0, temp = n;
    for (; temp > 0; temp /= 10) ++cnt;
    for (int i = n - 9*cnt; i < n; i++){
    	temp = i;
    	int result = i;
    	for (; temp > 0; temp /= 10) result += temp%10;
    	if (result == n)
    		return i;
	}
    return 0;
}
int main(){
	int N;
	scanf("%d", &N);
   	printf("%d\n", selfNum(N));
}