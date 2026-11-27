from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    H = [int(input()) for _ in range(N)]
    H.append(0)
    res = 0
    stack = [(0, H[0])]
    for idx, h in enumerate(H):
        top = idx
        while stack and stack[-1][1] > h :
            top, element = stack.pop()
            res = max(res, element * (idx - top))
        stack.append((top, h))
    print(res)
