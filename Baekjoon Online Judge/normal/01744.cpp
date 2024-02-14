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
    vector<int> plus, minus;
    for (int i = 0, val; i < N; ++i)
    {
        cin >> val;
        if (val > 0)
            plus.push_back(val);
        else if (val <= 0)
            minus.push_back(val);
    }
    // Solve
    sort(plus.begin(), plus.end());
    sort(minus.begin(), minus.end());

    int sum = 0; // (1'000*1'000)*25 = 25'000'000
    int idx = plus.size() - 1;
    if (idx == 0)
        sum += plus[0];
    else
    {
        for (; idx > 0; idx -= 2)
        {
            if (plus[idx] == 1 || plus[idx - 1] == 1)
                sum += plus[idx] + plus[idx - 1];
            else
                sum += plus[idx] * plus[idx - 1];
        }
        if (idx == 0)
            sum += plus[0];
    }

    idx = minus.size() - 1;
    if (idx == 0)
        sum += minus[0];
    else
    {
        for (int i = 0; i < idx; i += 2)
            sum += minus[i] * minus[i + 1];
        if (idx % 2 == 0)
            sum += minus[idx];
    }

    // Output
    cout << sum;
}
