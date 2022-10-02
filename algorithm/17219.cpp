#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);
	int N, M;
	cin >> N >> M;
	map<string, string> info;
	string site, pw;
	while (N--) {
		cin >> site >> pw;
		info[site] = pw;
	}
	while (M--) {
		cin >> site;
		cout << info[site] << '\n';
	}
}
