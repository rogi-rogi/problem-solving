N = int(input())
num = list(map(int, input().split()))
result = []
for i in range(N) :
    result.insert(i - num[i], i + 1)
for r in result :
    print(r, end = ' ')
