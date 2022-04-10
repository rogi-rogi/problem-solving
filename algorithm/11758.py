def CCW(v1, v2, v3) :
    result = (v2[0] - v1[0]) * (v3[1] - v1[1]) - (v3[0] - v1[0]) * (v2[1] - v1[1])
    if result == 0 : return 0
    return 1 if result > 0 else -1

if __name__ == "__main__" :
    v1 = list(map(int, input().split()))
    v2 = list(map(int, input().split()))
    v3 = list(map(int, input().split()))
    print(CCW(v1, v2, v3))
