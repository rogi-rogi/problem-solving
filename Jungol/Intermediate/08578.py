from sys import stdin

input = stdin.readline

if __name__ == '__main__':

    # Input
    N = int(input())
    ages = [*map(int, input().split())]

    # Solve
    ages.sort()

    answer = ages[1] - ages[0]
    for i in range(2, N):
        answer = min(answer, ages[i] - ages[i - 1])

    # Output
    print(answer)