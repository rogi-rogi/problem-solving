#include <iostream>
using namespace std;

int main()
{
    int birthday[3], today[3];
    for (int i = 0; i < 3; ++i) cin >> birthday[i];
    for (int i = 0; i < 3; ++i) cin >> today[i];
    int year[3];
    if (birthday[1] < today[1] || birthday[1] == today[1] && birthday[2] <= today[2]) year[0] = today[0] - birthday[0];
    else year[0] = today[0] - birthday[0] - 1;
    year[1] = today[0] - birthday[0] + 1;
    year[2] = today[0] - birthday[0];
    for (int i = 0; i < 3; ++i) cout << year[i] << '\n';
}
