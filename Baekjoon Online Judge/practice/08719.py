from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    res = []

    # Input
    for _ in range(int(input())):
        x, w = map(int, input().split())

        # Solve
        cnt = 0
        while x < w:
            x <<= 1
            cnt += 1
        res.append(cnt)
        
    # Output
    print(*res, sep='\n')
