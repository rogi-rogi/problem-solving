from sys import stdin
from heapq import heapify, heappop, heappush

input = stdin.readline

if __name__ == '__main__':
    # Input
    input()
    money = [*map(int, input().split())]
    input()
    drops = [*map(int, input().split())]

    # Solve
    heapify(money)
    for drop_money in drops:
        min_money = heappop(money)
        heappush(money, min_money + drop_money)

    money.sort()

    # Output
    print(*money)