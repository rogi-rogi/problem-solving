'''
대상 문자열(ori)에서 찾고자 하는 문자열(pat)이 존재하는지 선형시간안에 탐색가능한 알고리즘이다.
이 알고리즘을 만든 사람들의 이름을 따서, 'KMP(Knuth Morris Pratt) Algorithm'라 부른다.

알고리즘의 아이디어를 다음과 같이 정리해보았다.

대상 문자열(ori)과 찾고자 하는 문자열(pat)을 새로 비교할 때마다(문자열이 일치하지 않는 경우)
대상 문자열의 부분 접미사와 찾고자 하는 문자열의 접두사가 일치하는 부분 문자열이 있다면,
해당 부분 문자열 뒷부분을 이어서 비교하는 방식이다. 


createTable()
대상 문자열과 비교시 얼만큼 비교를 하지 않고 넘어갈 수 있는지 알기 위해,
찾고자 하는 문자열에 대해 얼마나 부분 일치(접두사와 접미사가 일치) 하는지 미리 표를 만들어주어야 한다.


https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
'''

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
