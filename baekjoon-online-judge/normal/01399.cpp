#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

typedef long long ll;

string words[10];
int alpha[26];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
        cin >> words[i];

    // Solve
    for (int i = 0; i < N; ++i)
    {
        int val = 1;
        for (int j = words[i].length() - 1; j >= 0; --j)
        {
            alpha[words[i][j] - 'A'] += val;
            val *= 10;
        }
    }
    sort(alpha, alpha + 26);
    ll res = 0;
    int num = 9;
    for (int i = 25; i >= 0; --i)
    {
        if (alpha[i] > 0)
        {
            res += alpha[i] * num;
            --num;
        }
    }

    // Output
    cout << res;
}
