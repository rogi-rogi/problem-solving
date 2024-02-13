#include <iostream>

using namespace std;
typedef long long ll;
const int MAX = 1e6;

int stock_price[MAX];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int T, N;
    cin >> T;
    while (T--)
    {
        cin >> N;
        for (int i = 0; i < N; ++i)
            cin >> stock_price[i];

        // Solve
        int max_price = stock_price[N - 1], cnt = 0;
        ll res = 0;
        for (int i = N - 2; i >= 0; --i)
        {
            if (stock_price[i] >= max_price)
                max_price = stock_price[i];
            else
                res += (max_price - stock_price[i]);
        }

        // Output
        cout << res << '\n';
    }
}
