#include <stdio.h>

int main()
{
    int C, N, grade[1000];
    scanf("%d", &C);
    while (C--){
        scanf("%d", &N);
        double sum = 0, cnt = 0;
        for (int i = 0; i < N; ++i) {
            scanf("%d", &grade[i]);
            sum += grade[i];
        }
        
        double avg = sum / N;
        for (int i = 0; i < N; ++i)
            if (avg < grade[i]) ++cnt;
        // double res = cnt * 100 / N;
        // double round45 = ((res*1000 - (int)(res*1000)) >= 0.5 ? 0.0001 : 0);
        printf("%.3f%%\n", cnt * 100 / N);
    }
}
