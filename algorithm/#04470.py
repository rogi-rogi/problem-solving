#include <iostream>
using namespace std;

int main()
{
    int N;
    string line;
    cin >> N;
    cin.ignore();
    for (int i = 1; i <= N; ++i) {
        getline(cin, line);
        cout << i << ". " << line << '\n';
    }
}
