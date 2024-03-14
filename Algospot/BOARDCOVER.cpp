/*
https://algospot.com/judge/problem/read/BOARDCOVER
*/

#include <iostream>

using namespace std;

typedef struct
{
    int x;
    int y;
} Point;

const Point COVER[4][3] = {
    {{0, 0}, {1, 0}, {0, 1}},
    {{0, 0}, {0, 1}, {1, 1}},
    {{0, 0}, {1, 0}, {1, 1}},
    {{0, 0}, {1, 0}, {1, -1}},
};

int board[21][21], H, W;

bool cover(Point &cur, int type, int diff)
{
    bool possible = true;
    for (int i = 0; i < 3; ++i)
    {
        int nx = cur.x + COVER[type][i].x;
        int ny = cur.y + COVER[type][i].y;
        if (nx < 0 || ny < 0 || nx >= H || ny >= W)
            possible = false;
        else if ((board[nx][ny] += diff) > 1)
            possible = false;
    }
    return possible;
}

Point find_empty()
{
    for (int i = 0; i < H; ++i)
        for (int j = 0; j < W; ++j)
            if (board[i][j] == 0)
                return {i, j};
    return {-1, -1};
}

int dfs()
{
    Point cur = find_empty();
    if (cur.x == -1)
        return 1;
    int cnt = 0;
    for (int type = 0; type < 4; ++type)
    {
        if (cover(cur, type, 1))
            cnt += dfs();
        cover(cur, type, -1);
    }
    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int TC;
    cin >> TC;
    char input;
    while (TC--)
    {
        cin >> H >> W;
        int white = 0;
        for (int i = 0; i < H; ++i)
        {
            for (int j = 0; j < W; ++j)
            {
                cin >> input;
                board[i][j] = (input == '.' ? 0 : 1);
                if (board[i][j] == 0)
                    ++white;
            }
        }

        // Solve & Output
        if (white % 3 != 0)
            cout << 0 << '\n';
        else
            cout << dfs() << '\n';
    }
}
