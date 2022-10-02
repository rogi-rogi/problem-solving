#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
    int N;
    cin >> N;
    map<string, int> books;
    string title;
    for (int i = 0; i < N; ++i) {
        cin >> title;
        ++books[title];
    }
    int cnt = 0;
    for (map<string, int>::iterator iter = books.begin(); iter != books.end(); ++iter) {
        if (cnt < iter->second) {
            cnt = iter->second;
            title = iter->first;
        }   // 'map' has been in ascending order according to the 'key'
    }
    cout << title << '\n';
}
