from sys import stdin
input=stdin.readline

print(*["Case %d: %d" %(tc, divmod(*map(int, input().split()))[1]) for tc in range(1, int(input()) + 1)], sep='\n')