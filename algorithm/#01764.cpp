#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

map<string, int> name;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N, M;
    cin >> N >> M;
    vector<string> res;
    for (int i = 0; i < N + M; ++i) {
        string str;
        cin >> str;
        ++name[str];
        if (name[str] >= 2) res.push_back(str);
    }
    sort(res.begin(), res.end());
    cout << res.size() << '\n';
    for (string s : res) cout << s << '\n';
}
