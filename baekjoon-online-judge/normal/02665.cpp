#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;
typedef long long ll;

const int INF = 987654321;
const int SIZE = 50;

int board[SIZE][SIZE];
int visited[SIZE][SIZE];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int bfs(int SIZE)
{
    fill(visited[0], visited[SIZE], INF);
    visited[0][0] = 0;
    queue<pair<int, int> > queue;
    queue.push({0, 0});
    int x, y, nx, ny;
    while (!queue.empty()) {
        x = queue.front().first;
        y = queue.front().second;
        queue.pop();
        for (int d = 0; d < 4; ++d) {
            nx = x + dx[d];
            ny = y + dy[d];
            if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE) {
                if (board[nx][ny] == 1) {
                    if (visited[nx][ny] > visited[x][y]) {
                        visited[nx][ny] = visited[x][y];
                        queue.push({nx, ny});
                    }
                } else if (visited[nx][ny] > visited[x][y] + 1) { // board[nx][ny] == 0
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.push({nx, ny});
                }
            }
        }
    }
    return visited[SIZE - 1][SIZE - 1];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    char room;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> room;
            board[i][j] = room - '0';
        }
    }
    cout << bfs(N);
}
