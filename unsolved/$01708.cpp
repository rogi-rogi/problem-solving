#include <algorithm>
#include <stack>
#include <vector>
#include <iostream>
 
using namespace std;
typedef long long ll; 

typedef struct __point{
    ll x, y;
} Point;

vector<Point> P;
Point std_p;

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
    int dir = CCW(std_p, A, B);
    if (dir == 0) return order_asc_yx(A, B);
    else return dir == 1;
}

int GrahamScan() {
    sort(P.begin(), P.end(), order_asc_yx);
    std_p = P[0];
    sort(P.begin() + 1, P.end(), order_ccw);
    
    Point P1 = std_p, P2 = P[1], P3;
    stack<Point> s;
    s.push(P1);
    s.push(P2);
    int SIZE = P.size();
    for (int i = 2; i < SIZE; ++i) {
        P3 = P[i];
        while (s.size() > 1) {
            P2 = s.top();
            s.pop();
            P1 = s.top();
            if (CCW(P1, P2, P3) == 1) {
                s.push(P2);
                break;
            }
        }
        s.push(P3);
    }
    return s.size();
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
