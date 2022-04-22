N = int(input())
print(('a' * (N // 2) + 'b' + 'a' * (N // 2)) if N & 1 else 'a' * N)
