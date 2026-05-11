from sys import stdin
from collections import defaultdict

input = stdin.readline

if __name__ == '__main__':
    count = defaultdict(int)
    answer = 0

    # Input
    for _ in range(int(input())):
        city, state = input().split()
        city_code = city[:2]

        # Solve
        if city_code != state:
            answer += count[(state, city_code)]
            count[(city_code, state)] += 1

    # Output
    print(answer)
