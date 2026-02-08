#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 1500;

int arr[MAX * MAX];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
            cin >> arr[i * N + j];
    }
    // Solve
    sort(arr, arr + N * N);

    // Output
    cout << arr[N * N - N];
}
