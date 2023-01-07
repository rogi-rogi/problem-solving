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

int manacher(const string& s, int N)
{
    int len = s.size();
    int r = 0, c = 0;
    int R[len] = {0,};
    for (int i = 0; i < len; ++i) {
        if (i <= r) R[i] = min(r - i, R[c + c - i]);
        while (0 <= i -R[i] -1 && i +R[i] +1 < len && s[i -R[i] -1] == s[i +R[i] +1]) ++R[i];
        if (r < i + R[i]) r = (c = i) + R[i];
    }
    int max_r = 0, idx = 0;
    for (int i = 0; i < len; ++i) {
        if (R[i] == N) return 0;
        /*
        전처리된 문자열의 끝 요소(왼쪽 또는 오른쪽)가 palindrome인 경우가 없다면,
        palindrome을 만들기 위해 최소 N - 1개의 문자를 추가해야 한다.(최악의 경우)
        따라서, 끝 요소까지 palindrome인 경우가 존재하고, 만약 R[i]의 값이 최대라면
        그때의 요소를 중점으로 부족한 문자개수(N - ((len - 1) - idx)만큼 추가하면 된다.
        */
        if (max_r < R[i] && (len - 1 - i == R[i])) max_r = R[(idx = i)];
    }
    return N - ((len - 1) - idx);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    string s;
    int N;
    cin >> N >> s;
    cout << manacher(manacher_preprocessing(s), N);
}
