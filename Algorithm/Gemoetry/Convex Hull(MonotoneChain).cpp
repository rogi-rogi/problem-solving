#include <algorithm>
#include <vector>
#include <iostream>
#define x first
#define y second

using namespace std;
typedef long long ll; 

vector<pair<ll, ll>> P;

int CCW(const pair<ll, ll>& A, const pair<ll, ll>& B, const pair<ll, ll>& C)
{
    ll cross_product = (B.x - A.x)*(C.y - A.y) - (C.x - A.x)*(B.y - A.y);
    if (!cross_product) return 0;
    return cross_product > 0 ? 1 : -1;
}

int MonotoneChain(int N)
{
    sort(P.begin(), P.end());
    vector<pair<ll, ll>> top_hull, bottom_hull;
    for (int i = 0; i < N; ++i) {
        int top_idx = top_hull.size() - 1;
        while (top_hull.size() > 1 && CCW(top_hull[top_idx -1], top_hull[top_idx], P[i]) <= 0) {
            top_hull.pop_back();
            --top_idx;
        }
        top_hull.push_back(P[i]);
    }
    for (int i = N - 1; i >= 0; --i) {
        int top_idx = bottom_hull.size() - 1;
        while (bottom_hull.size() > 1 && CCW(bottom_hull[top_idx -1], bottom_hull[top_idx], P[i]) <= 0) {
            bottom_hull.pop_back();
            --top_idx;
        }
        bottom_hull.push_back(P[i]);
    }
    return top_hull.size() + bottom_hull.size() - 2;
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
    cout << MonotoneChain(P.size());
}
