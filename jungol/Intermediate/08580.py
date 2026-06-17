from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    vectors = []

    for _ in range(int(input())):
        _, *sequence = map(int, input().split())
        vectors.append(sequence)

    # Solve
    order = [*map(int, input().split())]

    answer = []
    for idx in order:
        answer.append(' '.join(map(str, vectors[idx])))

    # Output
    print(*answer, sep='\n')