for TC in range(1, int(input()) + 1):
    K, N, M = map(int, input().split())
    charging_station = [False] * N
    for idx in [*map(int, input().split())] :
        charging_station[idx] = True
    cnt, cur = 0, 0
    while cur + K < N :
        for d in range(cur + K, cur, -1) :
            if charging_station[d] :
                cnt += 1
                cur = d
                break
        else :
            cnt = 0
            break
    print(f"#{TC} {cnt}")
