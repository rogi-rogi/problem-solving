MAX_N = 1_000
A = [0] * (MAX_N + 1)
A[0] = 1
A[1] = 1

for i in range(2, MAX_N + 1):
    nums = set()
    for k in range(1, i // 2 + 1):
        nums.add(2 * A[i-k] - A[i-2*k])

    num = 1
    while num in nums:
        num += 1
    A[i] = num

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    print(A[n])
