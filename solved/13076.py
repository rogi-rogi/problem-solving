from sys import stdin
input = stdin.readline

def EulerPhiList(n) :
    eulerList = [i for i in range(n + 1)]
    for i in range(2, n) :
        if eulerList[i] == i :
            for j in range(i, n + 1, i) :
                eulerList[j] -= eulerList[j] // i
    return eulerList

if __name__ == "__main__" :
    max_t = 10000
    eulerList = EulerPhiList(max_t)
    for i in range(1, max_t + 1) :
        eulerList[i] += eulerList[i - 1]
    for _ in range(int(input())) :
        print(eulerList[int(input())] + 1)
    
