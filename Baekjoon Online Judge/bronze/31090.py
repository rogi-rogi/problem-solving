from sys import stdin
input=stdin.readline

for _ in range(int(input())) :
    N = int(input())
    print(['Bye', 'Good'][(N+1)%(N % 100) == 0])
