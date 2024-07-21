if __name__ == '__main__':
    N = int(input())
    target = [*input().split()]
    prev_char = ''
    cnt = 0
    left, right = 0, N - 1

    prev_left_char = ''
    while left <= right:
        if target[left] != prev_char:
            prev_char = target[left]
            while target[left] == prev_char:
                left += 1
            while target[right] == prev_char:
                right -= 1
            cnt += 1
    print(cnt)
