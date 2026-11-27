from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    MAX = 1_000_001
    is_prime = [True] * MAX
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(MAX ** 0.5) + 1):
        for j in range(i * i, MAX, i):
            if is_prime[j]:
                is_prime[j] = False

    res = 1003001
    if N <= 98689:
        for i in range(N, MAX):
            if is_prime[i]:
                S = str(i)
                for j in range(len(S) // 2):
                    if S[j] != S[len(S) - j - 1]:
                        break
                else:
                    res = i
                    break
    # Output
    print(res)