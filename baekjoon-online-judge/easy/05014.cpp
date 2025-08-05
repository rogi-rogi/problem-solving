#include <iostream>
#include <queue>

using namespace std;

const int INF = 987654321;
const int MAX = 1e6 + 1;
int F, S, G, U, D;
int visited[MAX];

int bfs()
{
    fill(visited, visited + MAX, INF);
    visited[S] = 0;

    queue<int> queue;
    queue.push(S);
    int floor, upstairs, downstairs;
    while (!queue.empty())
    {
        floor = queue.front();
        if (floor == G)
            return visited[floor];
        queue.pop();

        upstairs = floor + U;
        downstairs = floor - D;
        if (upstairs <= F && visited[upstairs] == INF)
        {
            visited[upstairs] = visited[floor] + 1;
            queue.push(upstairs);
        }
        if (downstairs >= 1 && visited[downstairs] == INF)
        {
            visited[downstairs] = visited[floor] + 1;
            queue.push(downstairs);
        }
    }
    return -1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    cin >> F >> S >> G >> U >> D;

    // Solve
    int res = bfs();

    // Output
    if (res == -1)
        cout << "use the stairs";
    else
        cout << res;
}
