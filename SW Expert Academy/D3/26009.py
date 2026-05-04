MOD = 998_244_353

def solve():
    sum_a = A * (A + 1) // 2
    sum_b = B * (B + 1) // 2
    sum_c = C * (C + 1) // 2
    return (sum_a * (sum_b * sum_c) % MOD) % MOD

if __name__ == '__main__':
    # Input
    answer = []
    for _ in range(int(input())):
        A, B, C = map(int, input().split())
        # Solve
        answer.append(solve())

    # Output
    print(*answer, sep='\n')