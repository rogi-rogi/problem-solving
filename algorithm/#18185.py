from sys import stdin
input = stdin.readline

def buy(idx, no, t = -1) :
    if t == -1 : t = min(A[idx : idx + no])
    if no >= 2 :
        A[idx] -= t
        A[idx + 1] -= t
    if no == 3 : A[idx + 2] -= t
    return (1 + 2 * no) * t

if __name__ == "__main__" :
    N = int(input())
    A = [*map(int, input().split())] + [0, 0]
    cost = 0
    for i in range(N) :
        if A[i + 1] > A[i + 2] :
            cost += buy(i, 2, min(A[i], A[i + 1] - A[i + 2])) + buy(i, 3)
        else : cost += buy(i, 3) + buy(i, 2)
        cost += buy(i, 1)
    print(cost)
