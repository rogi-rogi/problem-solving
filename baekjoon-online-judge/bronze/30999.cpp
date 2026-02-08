#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N, M;
    cin >> N >> M;

    // Solve
    int res = 0;
    char temp;
    for (int i = 0; i < N; ++i)
    {
        int cnt = 0;
        for (int j = 0; j < M; ++j)
        {
            cin >> temp;
            if (temp == 'O')
                ++cnt;
            else
                --cnt;
        }
        if (cnt > 0)
            ++res;
    }

    // Output
    cout << res;
}
