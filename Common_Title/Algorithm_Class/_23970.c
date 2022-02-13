#include <stdio.h>
#include <string.h>
#define swap(a,b) do{int t = a;a=b,b=t;}while(0)
int main()
{
  int N;
  scanf("%d", &N);
  int A[N], B[N];
  for (int i = 0; i < N; i++) scanf("%d", &A[i]);
  for (int i = 0; i < N; i++) scanf("%d", &B[i]);
  if (!memcmp(A, B, sizeof(int)*N)){
    putchar('1');
    return 0;
  }
  for (int i = N - 1; i > 0;) {
    int last_idx = 0;
    for (int j = 0; j < i; j++){
      if (A[j] > A[j + 1]) {
        swap(A[j], A[j + 1]);
        last_idx = j;
        if (!memcmp(A, B, sizeof(int)*N)){
          putchar('1');
          return 0;
        }
      }
    }
    i = last_idx;
  }
  putchar('0');
}

#pypy3
#75%
from sys import stdin
N = int(stdin.readline())
A = list(map(int, stdin.readline().split()))
B = list(map(int, stdin.readline().split()))
if A == B : print(1)
else :
    i = N - 1
    while i > 0 :
        last = 0
        for j in range(i) :
            if A[j] > A[j + 1] :
                A[j], A[j + 1] = A[j + 1], A[j]
                last = j
                if A == B :
                    print(1)
                    exit(0)
        i = last
    print(0)
