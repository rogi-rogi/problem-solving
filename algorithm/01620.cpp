#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

map<string, int> names;
vector<string> nums(1);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
	int N, M;
	cin >> N >> M;
	string input;
	for (int i = 0; i < N; ++i){
		cin >> input;
		names[input] = (i + 1);
		nums.push_back(input);
	}
	while (M--) {
	    cin >> input;
	    if (input[0] <= '9') cout << nums[stoi(input)] << '\n';
	    else cout << names[input] << '\n';
	}
}
