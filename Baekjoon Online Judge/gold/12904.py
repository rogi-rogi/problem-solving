if __name__ == "__main__" :
    S = list(input())
    T = list(input())
    while len(S) < len(T) :
        t = T[-1]
        T = T[:-1]
        if t == 'B' :
            T = T[::-1]
    print([0, 1][S == T])
