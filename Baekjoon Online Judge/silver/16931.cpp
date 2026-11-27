#include <iostream>

using namespace std;

typedef long long ll;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int board[102][102];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N, M;
    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= M; ++j)
        {
            cin >> board[i][j];
        }
    }

    // Solve
    ll area = N * M * 2;
    for (int y = 1; y <= N; ++y)
    {
        for (int x = 1; x <= M; ++x)
        {
            for (int d = 0; d < 4; ++d)
            {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int height_diff = board[y][x] - board[ny][nx];
                if (height_diff > 0)
                    area += height_diff;
            }
        }
    }

    // Output
    cout << area;
}
