from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    P, Q = map(int, input().split())
    p_d, q_d = [], []
    for i in range(1, P + 1):
        if P % i == 0: p_d.append(i)
    for i in range(1, Q + 1):
        if Q % i == 0: q_d.append(i)
    for i in p_d:
        for j in q_d:
            print(i, j)
