#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int T, N;
    cin >> T;
    while (T-- > 0)
    {
        cin >> N;
        vector<pair<int, int>> v(N);
        for (int i = 0; i < N; ++i)
            cin >> v[i].first >> v[i].second;

        // Solve
        sort(v.begin(), v.end());
        int cnt = 1;
        int second_top_rank = v[0].second;
        for (int i = 1; i < N; ++i)
        {
            if (v[i].second < second_top_rank)
            {
                second_top_rank = v[i].second;
                ++cnt;
            }
        }

        // Output
        cout << cnt << '\n';
    }
}
