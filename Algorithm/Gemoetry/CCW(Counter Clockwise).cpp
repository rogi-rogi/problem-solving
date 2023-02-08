typedef struct __point {
    int x, y;
} Point;

int CCW(const Point& A, const Point& B, const Point& C)
{
    /*
    v1 : A -> B, v2 : A -> C
    cross_product : {0 : same}, {1 : ccw}, {-1 : cw}
    */
    int cross_product = (B.x - A.x)*(C.y - A.y) - (C.x - A.x)*(B.y - A.y);
    if (!cross_product) return 0;
    return cross_product > 0 ? 1 : -1;
}
