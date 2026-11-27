N, _ = map(int, input().split())
r, c = 1, 99
for i in range(1, N + 1) :
    temp = [*map(int, input().split())][0] if i == N else int(input())
    if c > temp :
        c = temp
        r = i
print(r, c + 1)
