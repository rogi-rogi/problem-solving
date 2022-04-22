cnt = 0
for i in range(8) :
    line = input()
    for j in range(i % 2, 8, 2) :
        if line[j] == 'F' : cnt += 1
print(cnt)
