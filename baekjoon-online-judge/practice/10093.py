if __name__ == '__main__':
    a, b = map(int, input().split())
    if a > b : a, b = b, a
    nums = [*range(a + 1, b)]
    print(len(nums))
    print(*nums)
