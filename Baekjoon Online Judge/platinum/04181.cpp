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

bool order_asc_xy(const Point& A, const Point& B)
{
    if (A.x != B.x) return A.x < B.x;
    else return A.y < B.y;
}

bool order_ccw(const Point& A, const Point& B)
{
    int dir = CCW(ref_p, A, B);
    if (dir == 0) {
        if (A.x == B.x) return A.y > B.y;
        return ((A.y == B.y) ? A.x < B.x : A.y > B.y);
    }
    return dir == 1;
}

void GrahamScan(int N)
{
    sort(P.begin(), P.end(), order_asc_xy);
    ref_p = P[0];
    sort(P.begin() + 1, P.end(), order_ccw);
    vector<Point> stack = { ref_p, P[1] };
    
    for (int i = 2; i < N; ++i) {
        int top_idx = stack.size() -1;
        while (stack.size() > 1 && CCW(stack[top_idx -1], stack[top_idx], P[i]) < 0) {
            stack.pop_back();
            --top_idx;
        }
        stack.push_back(P[i]);
    }
    cout << stack.size() << '\n';
    for (auto s : stack) cout << s.x << ' ' << s.y << '\n';
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    for (int i = 0, x, y; i < N; ++i) {
        cin >> x >> y;
        char c;
        cin >> c;
        if (c == 'Y') P.push_back({x, y});
    }
    GrahamScan(P.size());
}
