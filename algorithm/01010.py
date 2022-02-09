#dp
from sys import stdin

if __name__ == "__main__" :
    dp = [1, 1]
    temp = num = 1
    for _ in range(int(stdin.readline())):
        N, M = map(int, stdin.readline().split())
        if M > num :
            for i in range(num + 1, M + 1) :
                temp *= i  
                dp.append(temp)
            num = M
        print(dp[M] // (dp[N] * dp[M-N]))

#math
from sys import stdin

if __name__ == "__main__" :
    for _ in range(int(stdin.readline())):
        result = 1.0
        N, M = map(int, stdin.readline().split())
        for i in range(N) :
            result *= M - i
            result //= 1 + i
        print(int(result))
