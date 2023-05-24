# https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm

def createTable(pat, size) : # return partial match table for 'prefix == suffix'
    T = [0] * size # init all 0
    p = 0 # 'p' is prefix index
    for s in range(1, size) : # 's' is suffix index
        # pat[0 : p - 1]에 대해 prefix == suffix이므로, pat[s]가 sequence partial match string인지 table을 이용해 재탐색.
        while p > 0 and pat[p] != pat[s] :
            p = T[p - 1] 
        if pat[p] == pat[s] :
            p += 1
            T[s] = p
    return T
    
# Knuth Morris Pratt
def KMP(ori, pat) : # return first index list of string matching 'pat'
    pat_size = len(pat)
    T = createTable(pat, pat_size)
    find = []
    cur = 0
    for pos in range(0, len(ori)) :
        while cur > 0 and pat[cur] != ori[pos] :
            cur = T[cur - 1]
        if pat[cur] == ori[pos] :
            if cur == pat_size - 1 :
                find.append(pos - pat_size + 1)
                cur = T[cur]
            else : cur += 1
    return find
