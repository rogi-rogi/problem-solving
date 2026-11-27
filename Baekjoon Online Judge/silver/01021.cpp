#include <deque>
#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N, M;
    cin >> N >> M;
    deque<int> deque;
    for (int i = 1; i <= N; ++i)
        deque.push_back(i);

    int cnt = 0, target;
    while (M--)
    {
        cin >> target;
        // Solve
        int idx;
        for (int i = 0; i < N; ++i)
        {
            if (deque[i] == target)
            {
                idx = i;
                break;
            }
        }
        if (idx < N - idx)
        {
            while (target != deque.front())
            {
                deque.push_back(deque.front());
                deque.pop_front();
                ++cnt;
            }
        }
        else
        {
            while (target != deque.front())
            {
                deque.push_front(deque.back());
                deque.pop_back();
                ++cnt;
            }
        }

        deque.pop_front();
        --N;
    }

    // Output
    cout << cnt;
}
