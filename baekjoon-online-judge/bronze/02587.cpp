#include <algorithm>
#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int nums[5], sum = 0;
    for (int i = 0; i < 5; ++i)
    {
        cin >> nums[i];
        sum += nums[i];
    }

    // Solve
    sort(nums, nums + 5);

    // Output
    cout << sum / 5 << '\n'
         << nums[2];
}
