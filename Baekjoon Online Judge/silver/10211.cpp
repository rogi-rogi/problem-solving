#include <algorithm>
#include <iostream>
using namespace std;

int main()
{
    int T;
    cin >> T;
    while (T--) {
        int N, num, res = -999, sub_sum = 0;
        cin >> N;
        while (N--) {
            cin >> num;
            sub_sum += num;
            res = max(res, sub_sum);
            if (sub_sum < 0) sub_sum = 0;
        }
        cout << res << '\n';
    }
}
