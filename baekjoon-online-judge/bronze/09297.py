from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for i in range(1, int(input()) + 1):
        N, M = map(int, input().split())
        Q, R = divmod(N, M)

        # Solve
        res = None
        if Q != 0 and R != 0:
            res = f"Case {i}: {Q} {R}/{M}"
        elif Q == 0 and R != 0:
            res = f"Case {i}: {R}/{M}"
        elif R == 0 and Q != 0:
            res = f"Case {i}: {Q}"
        else:
            res = f"Case {i}: 0"

        # Output
        print(res)
        
