#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N, L;
    cin >> N >> L;
    vector<int> v(N);
    for (int i = 0; i < N; ++i)
        cin >> v[i];

    // Solve
    sort(v.begin(), v.end());
    int cnt = 0, prev_l = v[0];
    for (int i = 1; i < N; ++i)
    {
        if (v[i] - prev_l >= L)
        {
            ++cnt;
            prev_l = v[i];
        }
    }

    // Output
    cout << cnt + 1 << '\n';
}
