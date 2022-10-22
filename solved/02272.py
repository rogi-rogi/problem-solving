from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, M = map(int, input().split())
    status_of_lamp = [int(input()) for _ in range(N)]
    temp = [0] * N
    i = 1
    while i <= M :
        if i & M :
            for j in range(N) :
                temp[j] = status_of_lamp[j] ^ status_of_lamp[(i + j) % N]
            for j in range(N) :
                status_of_lamp[j] = temp[j]
        i <<= 1
    print(*status_of_lamp, sep = '\n')
