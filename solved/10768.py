day = [int(input()) for _ in range(2)]
temp = ["Before", "After"]
if day[0] == 2 :
    if day[1] == 18 : print("Special")
    else : print(temp[day[1] > 18])
else : print(temp[day[0] > 2])
