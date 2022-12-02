for _ in range(int(input())) :
    Lt, Wt, Le, We = map(int, input().split())
    if Lt * Wt == Le * We : print("Tie")
    else : print(["Eurecom", "TelecomParisTech"][Lt * Wt > Le * We])
