def O() :
    for n in range(n0, 101) :
        Fx =  a1 * n + a0
        if c1 * n > Fx or Fx > c2 * n : return 0
    return 1
    
a1, a0 = map(int, input().split())
c1, c2 = map(int, input().split())
n0 = int(input())
print(O())
