#include <algorithm>
#include <iostream>
#include <string>
#define SIZE 101
using namespace std;

int dp[SIZE][SIZE][SIZE];
string str1, str2, str3;

int LCS_length(int s1, int s2, int s3)
{
    if (str1[s1] == str2[s2] && str2[s2] == str3[s3]) return dp[s1][s2][s3] + 1;
    else return max(dp[s1 + 1][s2 + 1][s3], max(dp[s1][s2 + 1][s3 + 1], dp[s1 + 1][s2][s3 + 1]));
}

int main()
{
    cin >> str1 >> str2 >> str3;
    int s1 = str1.length(), s2 = str2.length(), s3 = str3.length();
    for (int i = 0; i < s1; ++i)
        for (int j = 0; j < s2; ++j)
            for (int k = 0; k < s3; ++k)
                dp[i + 1][j + 1][k + 1] = LCS_length(i, j, k);
    cout << dp[s1][s2][s3];
}
