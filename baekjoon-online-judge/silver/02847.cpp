#include <iostream>

using namespace std;
const int MAX = 101;

int score[MAX];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
        cin >> score[i];

    // Solve
    int cnt = 0;
    for (int i = N - 2; i >= 0; --i)
    {
        if (score[i] >= score[i + 1])
        {
            cnt += score[i] - score[i + 1] + 1;
            score[i] = score[i + 1] - 1;
        }
    }

    // Output
    cout << cnt;
}
