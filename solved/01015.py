N = int(input())
A = [*map(int, input().split())]
sorted_A = sorted(A)
P = []
for a in A :
    idx = sorted_A.index(a)
    P.append(idx)
    sorted_A[idx] = -1
print(*P)
