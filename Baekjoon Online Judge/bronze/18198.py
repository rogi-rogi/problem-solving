info = input()
A, B = 0, 0
for i in range(0, len(info), 2) :
    if   info[i] == 'A' : A += int(info[i + 1])
    elif info[i] == 'B' : B += int(info[i + 1])
print(['B', 'A'][A > B])
