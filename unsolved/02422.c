#include <stdio.h>

int ban_list[201][201];

int main()
{
    // input
    int N, M;
    scanf("%d %d", &N, &M);
    for (int i = 0, n1, n2; i < M; ++i) {
        int n1, n2;
        scanf("%d %d", &n1, &n2);
        ban_list[n1][n2] = ban_list[n2][n1] = 1;
    }
    
    // counting
    int cnt = 0;
    for (int n1 = 1; n1 <= N; ++n1) {
        for (int n2 = n1 + 1; n2 <= N; ++n2) {
            if (ban_list[n1][n2]) continue;
            for (int n3 = n2 + 1; n3 <= N; ++n3) {
                if (ban_list[n1][n3] || ban_list[n2][n3]) continue;
                ++cnt;
            }
        } 
    }
    printf("%d", cnt);
}
