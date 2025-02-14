input()
cnt = 0
for num in [*map(int, input().split())] :
    cnt += [-1, 1][num % 2 == 0]
print(["Sad", "Happy"][cnt > 0])
