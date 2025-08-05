from sys import stdin
input = stdin.readline
    
if __name__ == '__main__':
    N = int(input())
    id_list = [*map(int, input().split())]
    odd, even = 0, 0
    for a in id_list:
        if a % 2 == 1: odd += 1
        else: even += 1
    ans = 0
    while True:
        if ans % 2 == 0:
            if even > 0:
                even -= 1
            elif odd > 1:
                odd -= 2
            else:
                break
        else:
            if odd > 0:
                odd -= 1
            else:
                break
        ans += 1
    if odd > 0:
        ans -= 1
    print(ans)
