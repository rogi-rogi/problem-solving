/*
https://algospot.com/judge/problem/read/CLOCKSYNC
*/

#include <iostream>

using namespace std;

const int INF = 987654321;
const int MAX_BTN = 10;
const int MAX_CLOCK = 16;
const int TURN_ON[MAX_BTN][6] = {
    {3, 0, 1, 2},
    {4, 3, 7, 9, 11},
    {4, 4, 10, 14, 15},
    {5, 0, 4, 5, 6, 7},
    {5, 6, 7, 8, 10, 12},
    {4, 0, 2, 14, 15},
    {3, 3, 14, 15},
    {5, 4, 5, 7, 14, 15},
    {5, 1, 2, 3, 4, 5},
    {5, 3, 4, 5, 9, 13}};

int clocks[MAX_CLOCK];

int dfs(int btn)
{
    if (btn == MAX_BTN)
    {
        for (int i = 0; i < MAX_CLOCK; ++i)
            if (clocks[i] != 12)
                return INF;
        return 0;
    }
    int res = INF;
    for (int cnt = 0; cnt < 4; ++cnt)
    {
        res = min(res, cnt + dfs(btn + 1));
        for (int i = 1; i <= TURN_ON[btn][0]; ++i)
            clocks[TURN_ON[btn][i]] = clocks[TURN_ON[btn][i]] % 12 + 3;
    }
    return res;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int TC;
    cin >> TC;
    while (TC--)
    {
        for (int i = 0; i < MAX_CLOCK; ++i)
            cin >> clocks[i];

        // Solve & Output
        int res = dfs(0);
        cout << (res == INF ? -1 : res) << '\n';
    }
}
