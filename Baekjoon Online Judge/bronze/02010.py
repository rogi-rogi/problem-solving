from sys import stdin
input=stdin.readline

N = int(input())
print(sum([int(input()) for _ in range(N)])-(N-1))
