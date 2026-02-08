A, P = map(int, input().split())
A_price = A * 7
P_price = P * 13
if A_price == P_price : print("lika")
else : print(["Petra", "Axel"][A_price > P_price])
