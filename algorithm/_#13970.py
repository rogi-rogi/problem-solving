def EulerPhiList(n) :
    eulerList = [*range(n + 1)]
    for i in range(1, n) :
        for j in range(i + i, n + 1, i) :
                eulerList[j] -= eulerList[i]
    return eulerList
    
def power_towers(X, mod, x_size) :
    if mod == 1 : return 1
    if x_size >= 1 :
        x1 = X.pop(0)
        if x_size > 1 :
            temp = pow(x1, power_towers(X, eulerList[mod], x_size - 1), mod)
            return temp + [0, mod][temp < mod]
        return x1
    return 1
    
if __name__ == "__main__" :
    T, M = map(int, input().split())
    eulerList = EulerPhiList(M)
    for _ in range(T) :
        X = [*map(int, input().split())]
        x_size = X.pop(0)
        x1 = X.pop(0)
        if X :
            print(pow(x1, power_towers(X, eulerList[M], x_size - 1), M))
        else : print(x1 % M)
        
