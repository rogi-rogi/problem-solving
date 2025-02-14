if __name__ == '__main__':
    nums = [*map(int, [*input()])]
    cnt = [0] * 10
    for num in nums:
        cnt[num] += 1
    temp = 0
    if cnt[6] != cnt[9]:
        temp = (cnt[6] + cnt[9] + 1) // 2
        cnt[6] = cnt[9] = 0
    print(max(max(cnt), temp))

'''
if __name__ == '__main__':
    f = input().count
    print(max([*map(f, "01234578")] + [(f('6') + f('9') + 1) // 2]))
'''
