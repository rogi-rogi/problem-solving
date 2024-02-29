from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, C = map(int, input().split())
    M = int(input())
    box = [[*map(int, input().split())] for _ in range(M)]
    box.sort(key = lambda x : (x[0], x[1]))
    hold = [0] * (N + 1)
    capacity = 0
    idx = 0
    res = 0
    for v1 in range(1, N + 1) :
        res += hold[v1]
        capacity -= hold[v1]
        hold[v1] = 0
        while idx < M and box[idx][0] == v1 :
            _, v2, w = box[idx]
            if capacity + w <= C :
                hold[v2] += w
                capacity += w
            else :
                not_enough_w = w - (C - capacity)
                for over_v2 in range(N, v2, -1) :
                    if hold[over_v2] < not_enough_w :
                        not_enough_w -= hold[over_v2]
                        hold[over_v2] = 0
                    else :
                        hold[over_v2] -= not_enough_w
                        not_enough_w = 0
                        break
                hold[v2] += w - not_enough_w
                capacity = C
            idx += 1
    print(res)
