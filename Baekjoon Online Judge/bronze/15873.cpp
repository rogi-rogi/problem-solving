#include <iostream>
using namespace std;

int main()
{
    int AB, A, B;
    cin >> AB;
    if (AB == 1010) A = B = 10;     // 1010
    else if (AB % 100 == 10) {      //  x10
        A = AB / 100;
        B = 10;
    } else if (AB % 100 > 0) {      //  x0x
        A = AB / 10;
        B = AB % 10;
    } else if (AB < 100) {          //   xx
        A = 10;
        B = AB % 10;
    }
    cout << A + B;
}
