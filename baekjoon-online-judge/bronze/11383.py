if __name__ == '__main__':
    N, _ = map(int, input().split())
    A = ["".join([i * 2 for i in input()]) for _ in range(N)]
    B = ["".join(input()) for _ in range(N)]
    print(['Not Eyfa', 'Eyfa'][A == B])
