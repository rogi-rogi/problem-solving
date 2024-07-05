from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    while True:
        N, D = map(int, input().split())
        if N == D == 0:
            break
        X = [[*map(int, input().split())] for _ in range(D)]
        res = [int(all(x)) for x in zip(*X)]
        print(["no", "yes"][sum(res) > 0])
