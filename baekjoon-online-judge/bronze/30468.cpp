#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int STR, DEX, INT, LUK, N;
    cin >> STR >> DEX >> INT >> LUK >> N;

    // Solve & Output
    int sum = STR + DEX + INT + LUK;
    cout << (sum < 4 * N ? 4 * N - sum : 0);
}
