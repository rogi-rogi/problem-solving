#include <algorithm>
#include <iostream>
typedef long long ll;

using namespace std;

const int SIZE = 1e5;
ll rope[SIZE];

bool compare(const int &a, const int &b)
{
    return a > b;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
        cin >> rope[i];

    // Solve
    sort(rope, rope + N, compare);
    ll maxW = 0, curW;
    for (int i = 0; i < N; ++i)
    {
        curW = rope[i] * (i + 1);
        if (curW > maxW)
            maxW = curW;
    }

    // Output
    cout << maxW;
}
