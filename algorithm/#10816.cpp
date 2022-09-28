#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N;
    cin >> N;
    vector<int> v1(N);
    for (int i = 0; i < N; ++i) cin >> v1[i];
    sort(v1.begin(), v1.end());
    int M;
    cin >> M;
    for (int i = 0, key; i < M; ++i) {
        cin >> key;
        cout << upper_bound(v1.begin(), v1.end(), key) - lower_bound(v1.begin(), v1.end(), key) << " ";
    }
}


// use map
#include <iostream>
#include <map>
using namespace std;

map<int, int> card;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N;
    cin >> N;
    for (int i = 0, val; i < N; ++i) {
        cin >> val;
        ++card[val];
    }
    int M;
    cin >> M;
    for (int i = 0, key; i < M; ++i) {
        cin >> key;
        cout << ((card.find(key) != card.end()) ? card[key] : 0) << " ";
    }
}
