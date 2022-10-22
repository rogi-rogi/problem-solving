from sys import stdin
from itertools import combinations

if __name__ == "__main__" :
    N, M = map(int, stdin.readline().split())
    city = [list(map(int, stdin.readline().split())) for _ in range(N)]
    houses = []
    chicken = []
    for i in range(N) :
        for j in range(N) :
            if   city[i][j] == 1 :  houses.append((i, j))
            elif city[i][j] == 2 : chicken.append((i, j))
    min_distance = float('inf')
    for location in combinations(chicken, M) :
        sum_distance = 0
        for house in houses :
            sum_distance += min([abs(house[0]-temp[0]) + abs(house[1]-temp[1]) for temp in location])
            if min_distance <= sum_distance : break
        if sum_distance < min_distance : min_distance = sum_distance
    print(min_distance)
