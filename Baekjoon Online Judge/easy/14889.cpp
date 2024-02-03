#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 20;
int N;
int S[MAX];
int res = 987654321;

void bt(int num, int cnt, int stat)
{
    if (cnt == N / 2)
        res = min(res, abs(stat));
    else
        for (int i = num; i < N; ++i)
            bt(i + 1, cnt + 1, stat - S[i]);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0, temp; j < N; ++j)
        {
            cin >> temp;
            S[i] += temp;
            S[j] += temp;
        }
    }

    // Solve
    int sum_S = 0;
    for (int i = 0; i < N; ++i)
        sum_S += S[i];
    bt(0, 0, sum_S / 2);

    // Output
    cout << res;
}
