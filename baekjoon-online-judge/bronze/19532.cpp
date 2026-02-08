#include <iostream>

using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;

    // Solve
    for (int x = -999; x <= 999; ++x)
    {
        for (int y = -999; y <= 999; ++y)
        {
            if (a * x + b * y == c && d * x + e * y == f)
            {
                // Output
                cout << x << ' ' << y;
                return 0;
            }
        }
    }
}
