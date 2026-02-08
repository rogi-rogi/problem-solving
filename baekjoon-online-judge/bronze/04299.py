S, D = map(int, input().split())
if S < D or (S - D) % 2 != 0 : print(-1)
else : 
    t = (S + D) // 2
    print(*sorted([S - t, t])[::-1])
