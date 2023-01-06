#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

string manacher_preprocessing(string str)
{
    int len = (str.size() << 1) + 1;
    string re_str;
    re_str.resize(len);
    for (int i = 0; i < len; i += 2) {
        re_str[i] = '#';
        re_str[i + 1] = str[i >> 1];
    }
    return re_str;
}

int manacher(const string& s)
{
    int len = s.size();
    int r = 0, c = 0;
    int R[len] = {0,};
    for (int i = 0; i < len; ++i) {
        if (i <= r) R[i] = min(r - i, R[c + c - i]);
        while (0 <= i -R[i] -1 && i +R[i] +1 < len && s[i -R[i] -1] == s[i +R[i] +1]) ++R[i];
        if (r < i + R[i]) r = (c = i) + R[i];
    }
    int res = 0;
    for (int i = 0; i < len; ++i) res = max(res, R[i]);
    return res;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    string s;
    cin >> s;
    cout << manacher(manacher_preprocessing(s));
}
