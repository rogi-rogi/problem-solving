from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    T = [*map(int, input().split())]
    T.append(0)
    res = 0
    stack = [(0, T[0])]
    for idx, t in enumerate(T):
        top = idx
        while stack and stack[-1][1] > t :
            top, element = stack.pop()
            res = max(res, element * (idx - top))
        stack.append((top, t))
    print(res)
