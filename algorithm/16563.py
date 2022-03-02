from sys import stdin
input = stdin.readline

def SieveOfEratosthenes(n) :
    num = [i for i in range(n)]
    i = 2
    while i * i <= n :
        if num[i] == i:
            for j in range(2 * i, n, i) :
                if num[j] == j :
                    num[j] = i
        i += 1
    return num

if __name__ == "__main__" :
    input()
    facters = SieveOfEratosthenes(5000001)
    K = list(map(int, input().split()))
    for k in K :
        result = []
        while k > 1 :
            result.append(facters[k])
            k //= facters[k]
        print(*result)
