#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    unsigned int S;
    cin >> S;

    // Solve
    int num;
    for (num = 1; S >= num; ++num)
        S -= num;

    // Output
    cout << num - 1;
}
