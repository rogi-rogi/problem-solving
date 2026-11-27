#include <iostream>
#include <map>

using namespace std;

int main()
{
    int N;
    cin >> N;
    map<string, int> card;
    string name;
    int cnt;
    while (N--) {
        cin >> name >> cnt;
        card[name] += cnt;
    }
    char* res = "NO";
    for (auto iter = card.begin(); iter != card.end(); ++iter)
        if (iter->second == 5) res = "YES";
    cout << res;
}
