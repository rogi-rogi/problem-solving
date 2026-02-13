from sys import stdin
input=stdin.readline

for _ in range(3) :
    sumN = sum([int(input()) for _ in range(int(input()))])
    res = 0
    if sumN > 0 : res = '+'
    elif sumN < 0 : res = '-'
    print(res)
