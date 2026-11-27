from sys import stdin
input = stdin.readline

def calc(t):
    if t < 0:
        t += 2400
    elif t >= 2400:
        t -= 2400

    if t % 100 >= 60:
        t = 100 * (t // 100 + 1) + (t % 100 - 60)
    if t >= 2400:
        t -= 2400
    return t

if __name__ == '__main__':
    # Input
    T = int(input())

    # Solve & Output
    print(f'{T} in Ottawa')
    print(f'{calc(T - 300)} in Victoria')
    print(f'{calc(T - 200)} in Edmonton')
    print(f'{calc(T - 100)} in Winnipeg')
    print(f'{T} in Toronto')
    print(f'{calc(T + 100)} in Halifax')
    print(f'{calc(T + 130)} in St. John\'s')
