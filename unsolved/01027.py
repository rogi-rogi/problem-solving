def getSlope(p1, p2) :
    return (p2[1] - p1[1]) / (p2[0] - p1[0])

if __name__ == "__main__" :
    N = int(input())
    height = [*map(int, input().split())]
    res = 0
    for i in range(N) :
        cnt = 0
        min_slope = int(1e9) + 1
        for left in range(i - 1, -1, -1) :
            slope = getSlope((i + 1, height[i]), (left + 1, height[left]))
            if slope < min_slope :
                min_slope = slope
                cnt += 1
        max_slope = -int(1e9) -1
        for right in range(i + 1, N) :
            slope = getSlope((i + 1, height[i]), (right + 1, height[right]))
            if slope > max_slope :
                max_slope = slope
                cnt += 1
        res = max(res, cnt)
    print(res)
