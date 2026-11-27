#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;
    map<int, bool> set_A, set_B;
    int num;
    for (int i = 0; i < N; ++i) {
        cin >> num;
        set_A[num] = true;
    }
    for (int i = 0; i < M; ++i) {
        cin >> num;
        set_B[num] = true;
    }
    map<int, bool>::iterator iter;
    for (iter = set_B.begin(); iter != set_B.end(); ++iter) // A - B, N
        if (set_A.find(iter->first) != set_A.end()) --N;
    for (iter = set_A.begin(); iter != set_A.end(); ++iter) // B - A, M
        if (set_B.find(iter->first) != set_B.end()) --M;
    cout << N + M << '\n';
}
