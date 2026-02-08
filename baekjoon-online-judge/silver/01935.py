from sys import stdin

input = stdin.readline
if __name__ == '__main__':
    # Input
    N = int(input())
    F = [*input().rstrip()]
    num = {}
    for i in range(N):
        num[chr(ord("A") + i)] = int(input())

    # Solve
    stack = []
    for f in F:
        if f.isalpha():
            stack.append(num[f])
        else:
            B = stack.pop()
            A = stack.pop()
            stack.append(eval(str(A) + f + str(B)))

    # Output
    print("%.2f" % stack[0])