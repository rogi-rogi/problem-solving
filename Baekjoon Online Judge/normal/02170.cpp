#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
const int INF = 1e9;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N, x, y;
    cin >> N;
    vector<pair<int, int>> lines(N);
    for (int i = 0; i < N; ++i)
    {
        cin >> x >> y;
        lines[i] = {x, y};
    }

    // Solve
    sort(lines.begin(), lines.end());

    x = -INF;
    y = -INF;
    int res = 0;
    for (int i = 0; i < N; ++i)
    {
        if (lines[i].first > y)
        {
            res += (y - x);
            x = lines[i].first;
            y = lines[i].second;
        }
        else if (lines[i].second > y)
        {
            y = lines[i].second;
        }
    }

    // Output
    cout << res + (y - x);
}
