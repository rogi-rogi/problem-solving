for TC in range(1, int(input()) + 1):
    N, M = map(int, input().split())
    nums = [*map(int, input().split())]
    cur = sum(nums[:M])
    maxPartialSum = minPartialSum = cur
    for i in range(M, N) :
        cur = cur - nums[i - M] + nums[i]
        if cur > maxPartialSum : maxPartialSum = cur
        if cur < minPartialSum : minPartialSum = cur
    print(f"#{TC} {maxPartialSum - minPartialSum}")
