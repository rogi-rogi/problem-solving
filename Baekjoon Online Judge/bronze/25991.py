n = int(input())
C = [*map(float, input().split())]
for i in range(n) :
    C[i] = C[i] ** 3
print(pow(sum(C), 1/3))
