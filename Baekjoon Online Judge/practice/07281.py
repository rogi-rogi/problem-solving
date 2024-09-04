from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    res = 0
    prevTime = 0
    for _ in range(int(input())):
        time, connect = map(int, input().split())

        # Solve
        if connect == 1:
            res = max(res, time - prevTime)
            prevTime = time

    # Output
    print(res)
    
