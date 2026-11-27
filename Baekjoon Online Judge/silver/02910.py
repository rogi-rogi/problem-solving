from collections import Counter
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    # Input
    N, C = map(int, input().split())
    A = [*map(int, input().split())]

    # Solve
    counter_dict_a = [*Counter(A).items()]
    counter_dict_a = [(idx, *item) for idx, item in enumerate(counter_dict_a)]
    counter_dict_a.sort(key=lambda x: (-x[2], x[0]))
    res = []
    for idx, key, value in counter_dict_a:
        for _ in range(value):
            res.append(key)

    # Output
    print(*res)