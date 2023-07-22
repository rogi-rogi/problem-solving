def calc(a, b, op) :
    return [a+b, a-b, a*b, int(a/b)][op]

def dfs(n) :
    if n == N - 1 :
        ans[0] = max(ans[0], stack[N - 1])
        ans[1] = min(ans[1], stack[N - 1])
        return
    for idx in range(4) :
        if OP[idx] :
            OP[idx] -= 1
            stack.append(calc(stack[n], A[n + 1], idx))
            dfs(n + 1)
            stack.pop()
            OP[idx] += 1

if __name__ == "__main__" :
    N = int(input())
    A = [*map(int, input().split())]
    OP = [*map(int, input().split())]
    ans = [int(-1e9), int(1e9)] # [min, max]
    stack = [A[0]]
    dfs(0)
    print(*ans, sep='\n')
