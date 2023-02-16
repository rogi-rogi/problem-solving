#include <algorithm>
#include <vector>
#include <iostream>
 
using namespace std;
typedef long long ll; 

typedef struct __point{
    ll x, y;
} Point;

vector<Point> P;
Point ref_p;

int CCW(const Point& A, const Point& B, const Point& C)
{
    ll cross_product = (B.x - A.x)*(C.y - A.y) - (C.x - A.x)*(B.y - A.y);
    if (!cross_product) return 0;
    return cross_product > 0 ? 1 : -1;
}

bool order_asc_yx(const Point& A, const Point& B)
{
    if (A.y != B.y) return A.y < B.y;
    else return A.x < B.x;
}

bool order_ccw(const Point& A, const Point& B)
{
    int dir = CCW(ref_p, A, B);
    if (dir == 0) return order_asc_yx(A, B);
    else return dir == 1;
}

int GrahamScan()
{
    sort(P.begin(), P.end(), order_asc_yx);
    ref_p = P[0];
    sort(P.begin() + 1, P.end(), order_ccw);
    
    vector<Point> stack = { ref_p, P[1] };
    int SIZE = P.size();
    for (int i = 2; i < SIZE; ++i) {
        int top_idx = stack.size() -1;
        while (stack.size() > 1 && CCW(stack[top_idx -1], stack[top_idx], P[i]) <= 0) {
            stack.pop_back();
            --top_idx;
        }
        stack.push_back(P[i]);
    }
    return stack.size();
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    for (int i = 0, x, y; i < N; ++i) {
        cin >> x >> y;
        P.push_back({x, y});
    }
    cout << GrahamScan();
}
