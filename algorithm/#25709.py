N = int(input())
cnt = 0
while True:
    N = str(N)
    cnt += N.count('1')
    N = N.replace('1','')
    if N == '' : break
    N = int(N) - 1
    if N < 0 : break
    cnt += 1
print(cnt)
