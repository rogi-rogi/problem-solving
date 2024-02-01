#include <algorithm>
#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int height[9], diff = 0;
    for (int i = 0; i < 9; ++i)
    {
        cin >> height[i];
        diff += height[i];
    }

    // Solve
    diff -= 100;
    sort(height, height + 9);
    for (int i = 0; i < 9 - 1; ++i)
    {
        for (int j = i + 1; j < 9; ++j)
        {
            if (height[i] + height[j] == diff)
            {
                height[i] = height[j] = -1;
                // Output
                for (int k = 0; k < 9; ++k)
                {
                    if (height[k] != -1)
                        cout << height[k] << '\n';
                }
                return 0;
            }
        }
    }
}
