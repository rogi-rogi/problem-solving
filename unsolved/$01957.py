from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, M = map(int, input().split())
    status = [*input().rstrip()]
    for idx, s in enumerate(status) : status[idx] = [0, 1][s == 'u']
    temp = [0] * N
    i = 1
    while i <= M :
        if i & M :
            for j in range(N) :
                temp[j] = status[j] ^ status[(i + j) % N]
            for j in range(N) :
                status[j] = temp[j]
        i <<= 1
    for idx, s in enumerate(status) : status[idx] = ['d', 'u'][s == 1]
    print(*status, sep = '')
