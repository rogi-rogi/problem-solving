n = int(input())
k = int(input())
q = min(n, k + 60)
print(1500 * q + 3000 * (n - q))
