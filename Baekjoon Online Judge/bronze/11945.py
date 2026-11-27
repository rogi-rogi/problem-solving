N, _ = map(int, input().split())
print(*[input()[::-1] for _ in range(N)], sep = '\n')
