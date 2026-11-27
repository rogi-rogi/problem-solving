from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, S = map(int, input().split())

    # Solve
    answer = 0
    min_cost = 10 ** 18

    for _ in range(N):
        C, Y = map(int, input().split())
        min_cost = min(C, min_cost + S)

        answer += min_cost * Y

    # Output
    print(answer)