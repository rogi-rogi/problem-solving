from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    coin_cnt = sum(map(int, input().split()))

    # Solve & Output
    print([coin_cnt, N - coin_cnt][coin_cnt > N // 2])
