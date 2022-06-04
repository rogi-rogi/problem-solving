#include <stdio.h>
#include <math.h>

typedef struct circle_info{
    	int x, y, r;
} Circle;

int main()
{
	int T, result;
	scanf("%d", &T);
	while (T--){
	    Circle c[2];
	    for (int i = 0; i < 2; ++i)
	        scanf("%d %d %d", &c[i].x, &c[i].y, &c[i].r);
	        
		if (c[0].x == c[1].x && c[0].y == c[1].y && c[0].r == c[1].r) result = -1;
		else {
		    double d, diff_radius;
    		d = sqrt(pow(c[0].x - c[1].x, 2) + pow(c[0].y - c[1].y, 2));
    		diff_radius = abs(c[0].r - c[1].r);
    		int sum_radius = c[0].r + c[1].r;
    		if (d == sum_radius || d == diff_radius) result = 1;
    		else if (d < sum_radius && diff_radius < d) result = 2;
    		else result = 0;
		}
		printf("%d\n", result);
	}
}
