from sys import stdin
from collections import deque

input = stdin.readline


def i(x, y, z):
    queue.append((int(x), int(y), int(z)))


def o():
    if queue:
        x, y, z = queue.popleft()
        return f'{x} {y} {z}'
    return 'empty'


def c():
    return len(queue)


def z(a):
    if queue and queue[0][2] == int(a):
        return 'yes'
    return 'no'


if __name__ == '__main__':
    queue = deque()
    answer = []

    # Input
    for _ in range(int(input())):
        command = input().split()

        # Solve
        # insert
        if command[0] == 'i':
            i(command[1], command[2], command[3])

        # output & pop
        elif command[0] == 'o':
            answer.append(o())

        # count
        elif command[0] == 'c':
            answer.append(c())

        # check z
        elif command[0] == 'z':
            answer.append(z(command[1]))

    # Output
    print(*answer, sep='\n')