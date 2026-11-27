N = int(input())
A = [*map(int, input().split())]

res = 0
cnt = 1
for i in range(1, N) :
    if A[i] >= A[i - 1] : cnt += 1
    else :
        res += ((cnt*(cnt+1))/2)
        cnt = 1
if cnt >= 1 : res += ((cnt*(cnt+1))/2)
print(int(res))