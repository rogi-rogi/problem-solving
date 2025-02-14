from sys import stdin
input = stdin.readline

NULL = -1

if __name__ == '__main__':
    # Input
    a = NULL
    res = 0
    for _ in range(int(input())):
        t = int(input())

        # Solve
        if a == NULL: a = t
        else:
            res += t - a
            a = NULL

    # Output
    print(['still running', res][a == NULL])
