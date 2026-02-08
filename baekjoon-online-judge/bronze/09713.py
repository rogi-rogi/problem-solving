odd = [i for i in range(1, 101) if i % 2 == 1]
for _ in range(int(input())) :
    N = int(input())
    print(sum(odd[:1 + (N//2)]))
