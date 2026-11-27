if __name__ == "__main__" :
    N = int(input())
    tower = list(map(int, input().split()))
    stack = []
    result = [0] * N
    for i in range(N) :
        while stack and tower[i] > tower[stack[-1]] :
            stack.pop()
        if stack : result[i] = stack[-1] + 1
        stack.append(i)
    print(*result)
