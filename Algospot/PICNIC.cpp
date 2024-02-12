#include <iostream>

using namespace std;

int N;
bool is_friend[10][10];
bool is_mate[10];

int recursive()
{
    int a = -1;
    for (int i = 0; i < N; ++i)
    {
        if (!is_mate[i])
        {
            a = i;
            break;
        }
    }
    if (a == -1)
        return 1;

    int cnt = 0;
    for (int b = a + 1; b < N; ++b)
    {
        if (!is_mate[b] && is_friend[a][b])
        {
            is_mate[a] = is_mate[b] = true;
            cnt += recursive();
            is_mate[a] = is_mate[b] = false;
        }
    }
    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int C;
    cin >> C;
    int M, a, b;
    while (C--)
    {
        fill(is_friend[0], is_friend[10], false);
        fill(is_mate, is_mate + 10, false);
        cin >> N >> M;
        for (int i = 0; i < M; ++i)
        {
            cin >> a >> b;
            is_friend[a][b] = is_friend[b][a] = true;
        }
        // Solve & Output
        cout << recursive() << '\n';
    }
}
