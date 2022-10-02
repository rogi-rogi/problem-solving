#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
	int N, M;
	cin >> N >> M;
	string str;
	map<string, bool> set_str;
	for (int i = 0; i < N; ++i) {
	    cin >> str;
	    set_str[str] = true;
	}
	int cnt = 0;
	for (int i = 0; i < M; ++i) {
	    cin >> str;
	    if (set_str[str]) ++cnt;
	}
	cout << cnt << '\n';
}
