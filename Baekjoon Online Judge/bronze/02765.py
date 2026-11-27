from math import pi

i = 1
while True:
    D, R, T = map(float, input().split())
    if R == 0 : break
    distance = D / 63360 * pi * R
    MPH = distance / T * 3600
    print("Trip #%d: %.2f %.2f" % (i, distance, MPH))
    i += 1
