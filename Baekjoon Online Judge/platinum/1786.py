def createTable(size) :
    T = [0] * size
    p = 0
    for s in range(1, size) :
        while p > 0 and pat[p] != pat[s] :
            p = T[p - 1]
        if pat[p] == pat[s] :
            p += 1
            T[s] = p
    return T

def KMP() :
    pat_size = len(pat)
    T = createTable(pat_size)
    find = []
    cur = 0
    for pos in range(len(ori)) :
        while cur > 0 and pat[cur] != ori[pos] :
            cur = T[cur - 1]
        if pat[cur] == ori[pos] :
            if cur == pat_size - 1 :
                find.append(pos - pat_size + 2)
                cur = T[cur]
            else : cur += 1
    return find

if __name__ == "__main__" :
    ori = input()
    pat = input()
    res = KMP()
    print(len(res))
    print(*res)
