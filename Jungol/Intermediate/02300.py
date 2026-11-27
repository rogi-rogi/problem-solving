from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    L = [*map(int, input().split())]

    # Solve
    left, right = 0, N - 1
    answer_left = L[left]
    answer_right = L[right]
    best = abs(answer_left + answer_right)

    while left < right:
        total = L[left] + L[right]

        if abs(total) < best:
            best = abs(total)
            answer_left = L[left]
            answer_right = L[right]

        if total < 0:
            left += 1
        elif total > 0:
            right -= 1
        else:
            break

    # Output
    print(answer_left, answer_right)