time1 = list(map(int, input().split(':')))
time2 = list(map(int, input().split(':')))
res = [0] * 3
for i in range(3) : res[i] = time2[i] - time1[i]
if res[2] < 0 :
    res[2] += 60
    res[1] -= 1
if res[1] < 0 :
    res[1] += 60
    res[0] -= 1
if res[0] < 0 : res[0] += 24
if not any(res[i] != 0 for i in range(3)) : print("24:00:00")
else : print("%02d:%02d:%02d" %(res[0], res[1], res[2]))
