N = int(input())
data_list = [input() for _ in range(N)]
cnt = 0
for data in data_list:
    if 'CD' not in data:
        cnt += 1
print(cnt)
