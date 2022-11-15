K = int(input())
height, weight = 0, 0
height_idx, weight_idx = 0, 0
L = []
for i in range(6) :
    D, length = map(int, input().split())
    L.append(length)
    if (D == 3 or D == 4) and length > height :
        height = length
        height_idx = i
    elif (D == 1 or D == 2) and length > weight :
        weight = length
        weight_idx = i

s = 1
for l in L :
    if l not in [L[weight_idx - 1], L[(weight_idx + 1) % 6], L[height_idx - 1], L[(height_idx + 1) % 6]] :
        s *= l
print((weight * height - s) * K)
