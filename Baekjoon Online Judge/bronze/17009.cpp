#include <iostream>
using namespace std;

int main()
{
    int apple_score[3], banana_score[3], i;
    for (i = 0; i < 3; ++i) cin >> apple_score[i];
    for (i = 0; i < 3; ++i) cin >> banana_score[i];
    int total1 = 0, total2 = 0;
    for (i = 0; i < 3; ++i) total1 += (3 - i) * apple_score[i];
    for (i = 0; i < 3; ++i) total2 += (3 - i) * banana_score[i];
    if (total1 == total2) cout << 'T';
    else if (total1 < total2) cout << 'B';
    else cout << 'A';
}
