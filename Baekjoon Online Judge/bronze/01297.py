from math import sqrt

D, H, W = map(int, input().split())
H = H ** 2
W = W ** 2
temp = D**2 / (H + W)
print(int(sqrt(temp * H)), int(sqrt(temp * W)))
