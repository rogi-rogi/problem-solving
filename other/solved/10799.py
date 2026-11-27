from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    F = [*input().rstrip()]

    # Solve
    stack = []
    cnt = 0
    for i in range(len(F)):
        if F[i] == '(':
            stack.append(F[i])
        else: # F[i] == ')'
            if F[i - 1] == '(':
                stack.pop()
                cnt += len(stack)
            else:
                stack.pop()
                cnt += 1

    # Output
    print(cnt)