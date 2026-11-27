from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    prev_t = float(input())
    while True:
        cur_t = float(input())
        if cur_t == 999: break
        print("%.2f" % (cur_t-prev_t))
        prev_t = cur_t
