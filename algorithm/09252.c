#include <stdio.h>
#define EOS '\0'
#define max(a, b) (((a) > (b)) ? (a) : (b))

int dp[1001][1001];
char str1[1001], str2[1001];

int LCS_length(const char* str1, const char* str2, int s1, int s2)
{
    return ((str1[s1] == str2[s2]) ? dp[s1][s2] + 1 : max(dp[s1][s2 + 1], dp[s1 + 1][s2]));
}

void print_LCS(int i, int j)
{
    if (i == 0 || j == 0) return;
    if (dp[i][j]) {
        if (str1[i - 1] == str2[j - 1]) {
            print_LCS(i - 1, j - 1);
            putchar(str1[i - 1]);   // or str2[j - 1]
        } else dp[i - 1][j] > dp[i][j - 1] ? print_LCS(i - 1, j) : print_LCS(i, j - 1);
    }
}

int main()
{
    scanf("%s %s", &str1[0], &str2[0]);
    int s1, s2;
    for (s2 = 0; str2[s2] != EOS; ++s2)
        for (s1 = 0; str1[s1] != EOS; ++s1)
            dp[s1 + 1][s2 + 1] = LCS_length(&str1[0], &str2[0], s1, s2);
    printf("%d\n", dp[s1][s2]);
    print_LCS(s1, s2);
}
