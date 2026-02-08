if __name__ == '__main__':
    while True:
        try:
            H, P = map(int, input().split())
            print("%.2f" % (H/P))
        except:
            break
