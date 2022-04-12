def CCW(v1, v2, v3) :
    result = (v2[0] - v1[0]) * (v3[1] - v1[1]) - (v3[0] - v1[0]) * (v2[1] - v1[1])
    if result == 0 : return 0
    return 1 if result > 0 else -1 

if __name__ == "__main__" :
    temp = list(map(int, input().split()))
    v1, v2 = temp[:2], temp[2:]
    temp = list(map(int, input().split()))
    v3, v4 = temp[:2], temp[2:]
    if CCW(v1, v2, v3) != CCW(v1, v2, v4) and CCW(v3, v4, v1) != CCW(v3, v4, v2) :
        print(1)
    else : print(0)
