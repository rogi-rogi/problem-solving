FB = 0
LR = 0
D = {
    "N" : 1,
    "S" : -1,
    "W" : 1,
    "E" : -1
}
input()
for d in input() :
    if d in "NS" : FB += D[d]
    else : LR += D[d]
print(abs(FB) + abs(LR))
