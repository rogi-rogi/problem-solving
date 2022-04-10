L, P = map(int, input().split())
peoples = list(map(int, input().split()))
for i in range(5) :
    peoples[i] -= L * P
print(*peoples)
