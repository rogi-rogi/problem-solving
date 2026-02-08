for _ in range(int(input())):
    n, t = map(int, input().split())
    b = bin(n)[2:].count('1')
    print(["Corrupt", "Valid"][int(b) % 2 == t])