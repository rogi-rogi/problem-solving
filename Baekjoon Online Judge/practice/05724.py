from sys import stdin
input=stdin.readline

if __name__ == '__main__':
    while True:
        N = int(input())
        if N == 0:
            break
        dp = 1
        for i in range(N - 1):
            dp += (N - i) ** 2
        print(dp)
