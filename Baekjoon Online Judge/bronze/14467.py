from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    cows = {}
    cnt = 0
    for _ in range(int(input())):
        num, state = map(int, input().split())
        if num not in cows:
            cows[num] = state
        elif cows[num] != state:
            cows[num] = state
            cnt += 1
    print(cnt)
