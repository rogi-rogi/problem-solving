if __name__ == "__main__" :
    N, M = map(int, input().split())
    r, c = 1, 1
    min_distance = M * N
    for i in range(1, N) :
        distance = int(input())
        if distance < min_distance :
            min_distance = distance
            r = i
    
    distances = [*map(int, input().split())]
    if distances[0] < min_distance : r = N
    min_distance = M * N
    for col, distance in enumerate(distances) :
        if distance < min_distance :
            min_distance = distance
            c = col + 1
    print(r, c)
