def O() :
    for n in range(n0, 101) :
        if (c - a1) * n > a0 : return 0
    return 1
    
a1, a0 = map(int, input().split())
c = int(input())
n0 = int(input())
print(O())
