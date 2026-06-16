from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, X = map(int, input().split())

    vector = [X] * N

    while True:
        command = input().split()

        # Solve
        if command[0] == 'i':
            vector.append(int(command[1]))

        elif command[0] == 'r':
            if vector:
                vector.pop()

        elif command[0] == 's':
            vector.sort()

        elif command[0] == 't':
            if vector:
                vector[0], vector[-1] = vector[-1], vector[0]

        elif command[0] == 'e':
            # Output
            print(*vector)
            break