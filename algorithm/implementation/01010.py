from sys import stdin

if __name__ == "__main__" :
    T = int(stdin.readline())
    dp = [1, 1]
    temp = num = 1
    for _ in range(T):
        N, M = map(int, stdin.readline().split())
        if M > num :
            for i in range(num + 1, M + 1) :
                temp *= i  
                dp.append(temp)
            num = M
        print(dp[M] // (dp[N] * dp[M-N]))
