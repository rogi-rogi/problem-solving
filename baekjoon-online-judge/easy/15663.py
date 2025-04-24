from sys import stdin

input = stdin.readline

def bt():
    if len(temp) == M:
        res.append(' '.join(map(str, temp)))
        return

    prev = None
    for i in range(N):
        if A[i] != prev and not visited[i]:
            prev = A[i]
            temp.append(A[i])
            visited[i] = True
            bt()
            visited[i] = False
            temp.pop()


if __name__ == '__main__':
    # Input
    N, M = map(int, input().split())
    A = [*map(int, input().split())]

    # Solve
    A.sort()
    visited = [False] * N
    res = []
    temp = []

    bt()

    # Output
    print(*res, sep='\n')

# from itertools import permutations
# from sys import stdin
#
# input = stdin.readline
#
# if __name__ == '__main__':
#     # Input
#     N, M = map(int, input().split())
#     A = [*map(int, input().split())]
#
#     # Solve & Output
#     print(*[' '.join(map(str, e)) for e in sorted(set(permutations(A, M)))], sep='\n')
