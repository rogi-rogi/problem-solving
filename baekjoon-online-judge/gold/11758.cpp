#include <iostream>

using namespace std;

typedef struct __point {
    int x, y;
} Point;

int CCW(const Point& A, const Point& B, const Point& C)
{
    int cross_product = (B.x - A.x)*(C.y - A.y) - (C.x - A.x)*(B.y - A.y);
    if (!cross_product) return 0;
    return cross_product > 0 ? 1 : -1;
}

int main()
{
    Point P[3];
    for (int i = 0; i < 3; ++i) cin >> P[i].x >> P[i].y;
    cout << CCW(P[0], P[1], P[2]);
}
