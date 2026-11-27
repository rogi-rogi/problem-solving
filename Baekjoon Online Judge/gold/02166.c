#include <stdio.h>

typedef struct __point {
    double x, y;
} Point;

double CCW(const Point *A, const Point *B, const Point *C)
{
    double cross_product = (B->x - A->x)*(C->y - A->y) - (C->x - A->x)*(B->y - A->y);
    return cross_product;
}

int main()
{
	int N;
	scanf("%d", &N);
	Point P[N];
	for (int i = 0; i < N; i++)
		scanf("%lf %lf", &P[i].x, &P[i].y);
	
	double area = 0;
	for (int i = 1; i < N; i++)
	    area += CCW(&P[0], &P[i - 1], &P[i]) / 2;
	printf("%.1lf", area *= area < 0 ? -1 : 1);
}
