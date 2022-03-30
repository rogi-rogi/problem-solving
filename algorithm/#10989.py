from sys import stdin
input = stdin.readline

radix = [0] * 10001
for _ in range(int(input())) :
    radix[int(input())] += 1
for i in range(10001) :
    if radix[i] != 0 :
        for _ in range(radix[i]) :
            print(i)
