while True:
    a, b, c = map(int, input().split())
    if a == b == c == 0:
        break
    res = c - a + b
    if (c - a) % b == 0 and (c - a) // b >= 0 : print((c - a) // b + 1)
    else : print("X")
