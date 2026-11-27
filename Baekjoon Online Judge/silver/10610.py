N = list(map(int, input()))
if sum(N) % 3 == 0 and 0 in N :
    print(*sorted(N, reverse = True), sep = '')
else : print(-1)
