Wc, Hc, Ws, Hs = map(int, input().split())
print([0, 1][Wc - Ws >= 2 and Hc - Hs >= 2])
