from sys import stdin
from collections import defaultdict

input = stdin.readline


def f(x):
    return f'YES {dictionary[x]}' if x in dictionary else 'NO'


def a(x):
    dictionary[x] += 1


def c():
    return len(dictionary)


if __name__ == '__main__':
    # Input
    dictionary = defaultdict(int)
    answer = []
    for _ in range(int(input())):
        command, *args = input().split()

        # Solve
        if command == 'f':
            answer.append(f(args[0]))

        elif command == 'a':
            a(args[0])

        elif command == 'c':
            answer.append(c())

    # Output
    print(*answer, sep='\n')