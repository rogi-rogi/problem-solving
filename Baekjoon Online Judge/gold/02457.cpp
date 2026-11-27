#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    vector<pair<int, int>> days;
    int start_month, start_day, end_month, end_day;
    for (int i = 0; i < N; ++i)
    {
        cin >> start_month >> start_day >> end_month >> end_day;
        days.push_back({start_month * 100 + start_day, end_month * 100 + end_day});
    }

    // Solve
    sort(days.begin(), days.end());
    int end = 301, idx = 0, cnt = 0;
    while (end < 1201 && idx < N && days[idx].first <= end)
    {
        int cur_end = 0;
        for (int i = idx; i < N; ++i)
        {
            if (days[i].first <= end)
            {
                if (cur_end < days[i].second)
                    cur_end = days[i].second;
                ++idx;
            }
            else
                break;
        }
        end = cur_end;
        ++cnt;
    }

    // Output
    cout << (end >= 1201 ? cnt : 0);
}
