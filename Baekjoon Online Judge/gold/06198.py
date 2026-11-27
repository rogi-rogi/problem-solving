from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    bilding = [int(input()) for _ in range(N)]
    stack = []
    cnt = 0
    for i in range(N) :
        while stack and bilding[i] >= stack[-1] :
            stack.pop()
        stack.append(bilding[i])
        cnt += len(stack) - 1
    print(cnt)
