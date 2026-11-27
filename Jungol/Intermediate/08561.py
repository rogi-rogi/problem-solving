from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    name_frequency = {}

    # Input
    num = 1
    while True:
        name = input().rstrip()
        if name == 'end':
            break

        # Solve
        name_frequency[name] = num
        num += 1

    answer = [len(name_frequency),]
    for name, frequency in sorted(name_frequency.items()):
        answer.append(f'{name} {frequency}')

    # Output
    print(*answer, sep='\n')