from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    MOD = int(1e9) + 7
    result = 0
    for _ in range(int(input())) :
        N, S = map(int, input().split())
        result = (result + S * pow(N, MOD - 2, MOD)) % MOD
    print(result)
