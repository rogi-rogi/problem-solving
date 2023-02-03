#include <iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    string temp;
    int cnt = 0;
    while (getline(cin, temp)) {
        ++cnt;
    }
    cout << cnt;
}
