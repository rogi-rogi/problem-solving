from collections import Counter

if __name__ == '__main__':
    N = int(input())
    sub_arr = sorted(map(int, input().split()))
    counter = Counter(sub_arr)
    arr = []
    while len(arr) < N:
        for num in counter:
            if num > 0:
                min_element = num
                break
        arr.append(min_element)
        next_counter = Counter()
        for num, count in counter.items(): # old_count
            if count > 0:
                if num + min_element in counter:
                    counter[num + min_element] -= count
                next_counter[num] += count
        counter = next_counter
    print(*sorted(arr))
