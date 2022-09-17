#include <stdio.h>
#define EOS '\0'
#define max(a, b) (((a) > (b)) ? (a) : (b))

int dp[1001][1001];

int LCS_length(const char* str1, const char* str2, int s1, int s2)
{
    return ((str1[s1] == str2[s2]) ? dp[s1][s2] + 1 : max(dp[s1][s2 + 1], dp[s1 + 1][s2]));
}

int main()
{
    char str1[1001], str2[1001];
    scanf("%s %s", str1, str2);
    int s1, s2;
    for (s1 = 0; str1[s1] != EOS; ++s1)
        for (s2 = 0; str2[s2] != EOS; ++s2)
            dp[s1 + 1][s2 + 1] = LCS_length(str1, str2, s1, s2);
    printf("%d", dp[s1][s2]);
}
