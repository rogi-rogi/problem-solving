#include <iostream>
using namespace std;

int main()
{
    int cnt = 6, win = 0;
    char temp;
    while (cnt--) {
        cin >> temp;
        if (temp == 'W') ++win;
    }
    cout << (win == 0 ? -1 : win <= 2 ? 3 : win <= 4 ? 2 : 1);
}
