#include <algorithm>
#include <iostream>
using namespace std;

int main()
{
    int N, A, B, C, D;
    cin >> N >> A >> B >> C >> D;
    cout << min(B * (N / A + (N % A != 0)), D * (N / C + (N % C != 0)));
}
