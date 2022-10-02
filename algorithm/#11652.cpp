#include <iostream>
#include <map>
#include <string>
#define ll long long
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, cnt = 0;
    ll num, res;
    cin >> N;
    map<ll, int> cards;
    for (int i = 0; i < N; ++i) {
        cin >> num;
        cards[num];
    } 
    for (map<ll, int>::iterator iter = cards.begin(); iter != cards.end(); ++iter) {
        if (cnt < iter->second) {
            cnt = iter->second;
            res = iter->first;;
        } else if (cnt == iter->second && res > iter->first) res = iter->first;
    }
    cout << res << '\n';
}
