from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    A = list(map(int, input().split()))
    NGE = [-1] * N
    stack = [0]
    for i in range(1, N) :
        while stack and A[stack[-1]] < A[i] :
            NGE[stack.pop()] =A[i] 
        stack.append(i)
    print(*NGE)
    
