def CCW(v1, v2, v3) :
    result = (v2[0] - v1[0]) * (v3[1] - v1[1]) - (v3[0] - v1[0]) * (v2[1] - v1[1])
    if result == 0 : return 0
    return 1 if result > 0 else -1 

def check(v1, v2, v3, v4) :
    r1 = CCW(v1, v2, v3)
    r2 = CCW(v1, v2, v4)
    r3 = CCW(v3, v4, v1)
    r4 = CCW(v3, v4, v2)
    if r1 == r2 == 0 and r3 == r4 == 0 :
        if v1 > v2 : v1, v2 = v2, v1
        if v3 > v4 : v3, v4 = v4, v3
        return (1 if v1 <= v4 and v3 <= v2 else 0)
    return (1 if r1 != r2 and r3 != r4 else 0)

def isInBox(v, v3, v4, v5) :
    return (v3[0] <= v[0] <= v4[0] and v5[1] <= v[1] <= v3[1])
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        temp = list(map(int, input().split()))
        v1, v2 = temp[:2], temp[2:4]
        v3 = [min(temp[4], temp[6]), max(temp[5], temp[7])]
        v4 = [max(temp[4], temp[6]), min(temp[5], temp[7])]
        v5, v6 = [v3[0], v4[1]], [v4[0], v3[1]]
        # 3 6
        # 5 4
        result = 'F'
        if isInBox(v1, v3, v4, v5) and isInBox(v2, v3, v4, v5) : result = 'T'
        # v3-v5, v3-v6, v4-v5, v4-v6
        for i in [v3, v4] :
            for j in [v5, v6] :
                if check(v1, v2, i, j) :
                    result = 'T'
        print(result)
