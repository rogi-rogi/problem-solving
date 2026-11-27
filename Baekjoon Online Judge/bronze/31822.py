code = input()[:5]
cnt = 0
for _ in range(int(input())):
    if input()[:5] == code:
        cnt += 1
print(cnt)
