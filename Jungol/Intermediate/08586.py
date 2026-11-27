from sys import stdin

input = stdin.readline

if __name__ == '__main__':

    # Input
    A = [tuple(map(int, input().split())) for _ in range(int(input()))]

    # Solve
    A.sort(key=lambda x: (x[0], -x[1], x[2], -x[3], x[4]))

    # Output
    answer = []
    for a in A:
        answer.append('%d %d %d %d %d' % a)
    print(*answer, sep='\n')