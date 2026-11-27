#include <stdio.h>
#define MIN(a,b) (a < b ? a: b)
int main(){
	int x, y, w, h, min;
	scanf("%d %d %d %d", &x, &y, &w, &h);
	printf("%d", MIN(MIN(w - x, x), MIN(h - y, y)));
}