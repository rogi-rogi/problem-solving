#include <iostream>

using namespace std;

typedef long long ll;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N, K;
    cin >> N >> K;
    int nums[N];
    for (int i = 0; i < N; ++i)
        cin >> nums[i];

    // Solve
    ll prefix_sum = 0, res;
    for (int i = 0; i < K; ++i)
        prefix_sum += nums[i];
    res = prefix_sum;
    for (int i = K; i < N; ++i)
    {
        prefix_sum += (nums[i] - nums[i - K]);
        if (res < prefix_sum)
            res = prefix_sum;
    }

    // Output
    cout << res;
}
