#include <stdio.h>

int main()
{
  int N, K;
  scanf("%d %d", &N, &K);
  int  a = 1, b = 1;
  for (int i = 0; i < K; ++i) {
    a *= (N - i);
    b *= (K - i);
  }
  printf("%d", a / b);
}
