#include <iostream>
using namespace std;

int A[1001] = {1, 1, };

int main()
{
    int n;
    cin >> n;
    for (int i = 2; i <= n; ++i) {
        for (int val = 1, flag = 1; flag; ++val) {
            flag = 0;
            A[i] = val;
            for (int k = 1; i - 2 * k >= 0; ++k) {
                if (A[i] - A[i - k] == A[i - k] - A[i - 2 * k]) {
                    flag = 1;
                    break;
	        }
	    }
	}
    }
    cout << A[n];
}
