#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;
    int first_x, second_x;
    cin >> first_x;
    int res = first_x;
    while (--N) {
        cin >> second_x;
        if (second_x - first_x != 1) res += second_x;
        first_x = second_x;
    }
    cout << res;
}
