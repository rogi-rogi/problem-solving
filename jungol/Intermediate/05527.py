from sys import stdin
from collections import deque

input = stdin.readline


def call(x):
    waiting.append(int(x))


def wait(x):
    time = int(x)

    while waiting and time > 0:
        if waiting[0] > time:
            waiting[0] -= time
            break
        else:
            time -= waiting.popleft()


def check():
    return f'{len(waiting)} people {sum(waiting)} minutes'


if __name__ == '__main__':
    waiting = deque()
    answer = []

    # Input
    for _ in range(int(input())):
        command = input().split()

        # Solve
        if command[0] == 'call':
            call(command[1])

        elif command[0] == 'wait':
            wait(command[1])

        elif command[0] == 'check':
            answer.append(check())

    # Output
    print(*answer, sep='\n')