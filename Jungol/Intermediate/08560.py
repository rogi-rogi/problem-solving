from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    A = []
    for i in range(10):
        name, age = input().split()
        A.append((name, int(age)))

    # Solve
    A.sort(key=lambda x: (-x[1], x[0]))
    answer = ['%s %d' % a for a in A]

    # Output
    print(*answer, sep='\n')