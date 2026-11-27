N = int(input())
call = [0] + [*map(int, input().split())]
block = -1
for i in range(1, N + 1) :
    if call[i] == i :
        block = i
        break

cnt = 0
if block != -1 :
    last_block = [1, 2][block == 1]
    for i in range(block + 1, N + 1) :
        if call[i] == i :
            call[i] = block
            last_block = i
            cnt += 1
    call[block] = last_block
    cnt += 1

print(cnt)
del call[0]
print(*call)