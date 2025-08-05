from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N, K, B = map(int, input().split())
    nums = [0] * (N + 1)
    for _ in range(B):
        nums[int(input())] = 1

    # Solve
    res = sum(nums[:K + 1])
    temp = res
    for i in range(1, N + 1 - K):
        temp = temp - nums[i] + nums[i + K]
        res = min(res, temp)

    # Output
    print(res)
