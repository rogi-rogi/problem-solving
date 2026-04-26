#include <stdio.h>
int main() {
    int N;
    float num, temp = 0;
    double avg = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; i++){
    	scanf("%f", &num);
        if (num > temp)
            temp = num;
        avg += num;
   }
   printf("%lf", (avg / temp) / N * 100);
}