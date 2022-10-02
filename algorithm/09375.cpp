#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
    int T, n;
    cin >> T;
    while (T--) {
        cin >> n;
        map<string, int> info;
        string name, kinds;
		
        while (n--) {
            cin >> name >> kinds;
            if (info[kinds]) ++info[kinds];
            else info[kinds] = 1;
        }
        int res = 1;
        for (map<string, int>::iterator iter = info.begin(); iter != info.end(); ++iter)
            res *= (iter->second + 1);
        cout << res - 1 << '\n';
    }
}

/*
from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    clothes_types = []
    for _ in range(int(input())) :
        clothes_types.append(input().split()[1])
    set_clothes = set(clothes_types)
    cnt = 1
    for i in set_clothes :
        cnt *= (clothes_types.count(i) + 1)
    print(cnt - 1)
*/
