while True :
    info = input().split()
    if info == ['#','0','0'] : break
    print(info[0] + " " + ["Junior", "Senior"][int(info[1]) > 17 or int(info[2]) >= 80])
