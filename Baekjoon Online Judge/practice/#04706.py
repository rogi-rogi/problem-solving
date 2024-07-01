while True:
    a, b = map(float, input().split())
    if a == b == 0: break
    print('%.3f' % ((1 - (b/a)**2) ** 0.5))
