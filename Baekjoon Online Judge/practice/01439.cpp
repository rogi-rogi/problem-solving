#include <iostream>
#include <string>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    string S;
    cin >> S;

    // Solve
    int SIZE = S.length();
    int cnt = 1;
    for (int i = 1; i < SIZE; ++i)
    {
        if (S[i] != S[i - 1])
            ++cnt;
    };

    // Output
    cout << cnt / 2;
}
