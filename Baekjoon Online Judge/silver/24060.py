from sys import stdin

input = stdin.readline

def check_cnt():
    global cnt
    cnt += 1
    return cnt == K


def merge_sort(left, right):
    if left >= right:
        return
    mid = (left + right) // 2
    merge_sort(left, mid)
    merge_sort(mid + 1, right)
    merge(left, mid, right)


def merge(left, mid, right):
    global res
    temp = []
    l, r = left, mid + 1
    while l <= mid and r <= right:
        if arr[l] <= arr[r]:
            temp.append(arr[l])
            l += 1
        else:
            temp.append(arr[r])
            r += 1

    while l <= mid:
        temp.append(arr[l])
        l += 1

    while r <= right:
        temp.append(arr[r])
        r += 1

    # Update original array with sorted values
    for i in range(left, right + 1):
        arr[i] = temp[i - left]
        if check_cnt(): res = arr[i]

if __name__ == '__main__':
    # Input
    _, K = map(int, input().split())
    arr = list(map(int, input().split()))

    # Solve
    cnt, res = 0, -1
    merge_sort( 0, len(arr) - 1)

    # Output
    print(res)
