from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, K = map(int, input().split())
    num = list(input().rstrip())
    stack = []
    cnt = K
    for i in range(N) :
        while cnt > 0 and stack and stack[-1] < num[i] :
            stack.pop()
            cnt -= 1
        stack.append(num[i])
    print(''.join(stack[:N-K]))
