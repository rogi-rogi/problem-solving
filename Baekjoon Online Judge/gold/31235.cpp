#include <iostream>

using namespace std;

const int SIZE = 1e6;
int A[SIZE];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
        cin >> A[i];

    // Solve
    int diff = 1, K = 1, prev_max_a = A[0];
    for (int i = 1; i < N; ++i)
    {
        if (A[i] < prev_max_a)
        {
            ++diff;
            K = max(K, diff);
        }
        else
        {
            prev_max_a = A[i];
            diff = 1;
        }
    }

    // Output
    cout << K << '\n';
}
