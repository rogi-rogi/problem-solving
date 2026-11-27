#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    map<string, bool> names;
    for (int i = 0; i < n; ++i) {
        string name, work;
        cin >> name >> work;
        names[name] = ((work == "enter") ? true : false);
    }
    for (auto iter = names.rbegin(); iter != names.rend(); ++iter)
        if (iter->second) cout << iter->first << '\n';
}
