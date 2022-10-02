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
