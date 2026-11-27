if __name__ == '__main__':
    # Input
    N = int(input())
    W = [*map(int, input().split())]

    # Solve
    W.sort()
    answer = 0
    for w in W:
        if answer + 1 < w:
            break
        answer += w

    # Output
    print(answer + 1)
