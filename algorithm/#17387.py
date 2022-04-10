def CCW(v1, v2, v3) :
    result = (v2[0] - v1[0]) * (v3[1] - v1[1]) - (v3[0] - v1[0]) * (v2[1] - v1[1])
    if result == 0 : return 0
    return 1 if result > 0 else -1 

if __name__ == "__main__" :
    temp = list(map(int, input().split()))
    v1, v2 = temp[:2], temp[2:]
    temp = list(map(int, input().split()))
    v3, v4 = temp[:2], temp[2:]
    r1 = CCW(v1, v2, v3)
    r2 = CCW(v1, v2, v4)
    r3 = CCW(v3, v4, v1)
    r4 = CCW(v3, v4, v2)
    if r1 == r2 == 0 and r3 == r4 == 0 :
        if v1 > v2 : v1, v2 = v2, v1
        if v3 > v4 : v3, v4 = v4, v3
        print(1 if v1 <= v4 and v3 <= v2 else 0)
    elif r1 != r2 and r3 != r4 : print(1)
    else : print(0)
