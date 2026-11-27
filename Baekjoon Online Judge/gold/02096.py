from sys import stdin
input = stdin.readline

if __name__ == "__main__":
    N = int(input())
    board = [*map(int, input().split())]
    max_dp = list(board)
    min_dp = list(board)
    for i in range(1, N) :
        board = [*map(int, input().split())]
        toggle = [max_dp[0], max_dp[2]]
        max_dp[0] = board[0] + max(max_dp[0], max_dp[1])
        max_dp[2] = board[2] + max(max_dp[1], max_dp[2])
        max_dp[1] = board[1] + max(*toggle, max_dp[1])
        toggle = [min_dp[0], min_dp[2]]
        min_dp[0] = board[0] + min(min_dp[0], min_dp[1])
        min_dp[2] = board[2] + min(min_dp[1], min_dp[2])
        min_dp[1] = board[1] + min(*toggle, min_dp[1])
        
    print(max(max_dp), min(min_dp))
