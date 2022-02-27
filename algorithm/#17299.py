from collections import Counter
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    A = list(map(int, input().split()))
    F = Counter(A)
    NGF = [-1] * N
    stack = []
    for i in range(N) :
        while stack and F[A[i]] > F[A[stack[-1]]] :
            NGF[stack.pop()] = A[i]
        stack.append(i)
    print(*NGF)
