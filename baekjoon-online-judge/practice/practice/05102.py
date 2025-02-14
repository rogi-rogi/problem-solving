while True :
    pairCnt, groupCnt = map(int, input().split())
    if pairCnt == groupCnt == 0 : break
    diff = pairCnt - groupCnt
    if diff > 3 :
        print(diff // 2 - diff % 2, diff % 2)
    elif diff == 3 : print(0, 1)
    elif diff == 2 : print(1, 0)
    else : print(0, 0)
