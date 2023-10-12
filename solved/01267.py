N = int(input())
Y, M = 0, 0
for num in [*map(int, input().split())] :
    Y += 10 *((num // 30) + 1)
    M += 15 *((num // 60) + 1)
if Y == M :  print('Y', 'M', Y)
elif Y < M : print('Y', Y)
else :       print('M', M)
