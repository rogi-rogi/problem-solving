from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    str1 = input()
    str2 = input()

    # Solve
    cnt = 0
    for i in range(N):
        if str1[i] != str2[i]:
            cnt += 1

    # Output
    print(cnt)
