#include <algorithm>
#include <iostream>
using namespace std;

int main()
{
    int N, res = 1, temp, asc = 1, des = 1;
    cin >> N >> temp;
    while (--N) {
        int num;
        cin >> num;
        if (num > temp) {
            ++asc;
            des = 1;
        } else if (num < temp) {
            ++des;
            asc = 1;
        } else {
            ++asc;
            ++des;
        }
        res = max(res, max(asc, des));
        temp = num;
    };
    cout << res;
}
