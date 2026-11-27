N, M = map(int, input().split())
cnt = sum(['+' in input() for _ in range(N)])
print(cnt)
