cnt = 0
for _ in range(int(input())) :
    line = input()
    if '01' in line or 'OI' in line :
        cnt += 1
print(cnt)
