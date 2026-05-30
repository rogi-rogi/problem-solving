from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, Q = map(int, input().split())
    H = [*map(int, input().split())]

    # Solve
    idx = H.index(max(H))

    pos = {}

    for i, h in enumerate(H):
        pos[h] = i

    answer = []
    for _ in range(Q):
        x = int(input())

        if x not in pos:
            answer.append('N')
        else:
            i = pos[x]

            if i < idx:
                answer.append('L')
            elif i > idx:
                answer.append('R')
            else:
                answer.append('T')

    # Output
    print(*answer, sep='\n')