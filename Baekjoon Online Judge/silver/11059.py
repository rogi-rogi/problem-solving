def solve(s):
    n = len(s)
    prefix = [0]
    for digit in s:
        prefix.append(prefix[-1] + int(digit))
        
    for half in range(n // 2, 0, -1):
        length = 2 * half
        for start in range(n - length + 1):
            mid = start + half
            end = start + length
            left_sum = prefix[mid] - prefix[start]
            right_sum = prefix[end] - prefix[mid]
            if left_sum == right_sum:
                return length
    return 0


if __name__ == '__main__':
    print(solve(input().strip()))
