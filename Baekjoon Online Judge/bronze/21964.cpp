#include <iostream>
#include <string>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    string S;
    cin >> N;
    cin >> S;
    
    // Solve & Output
    int SIZE = S.size();
    for (int i = SIZE - 5; i < SIZE; ++i)
        cout << S[i];
}
