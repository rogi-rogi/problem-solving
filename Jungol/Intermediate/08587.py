from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def push(name, age, blood):
    heappush(pq, (-float(blood), -int(age), name))


def pop():
    if pq:
        return heappop(pq)[2]


if __name__ == '__main__':
    pq = []
    answer = []

    # Input
    for _ in range(int(input())):
        command = input().split()

        # Solve
        if command[0] == 'push':
            push(command[1], command[2], command[3])

        elif command[0] == 'pop':
            result = pop()

            if result:
                answer.append(result)

    # Output
    print(*answer, sep='\n')