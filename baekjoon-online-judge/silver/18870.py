'''
from sys import stdin
input = stdin.readline

def lowerBound(temp, key) :
    left = 0
    right = len(temp)
    while left < right :
        mid = (left + right) // 2
        if temp[mid] < key : left = mid + 1
        else : right = mid
    return left

N = int(input())
target = [*map(int, input().split())]
temp = sorted(set(target))
print(*[lowerBound(temp, target[i]) for i in range(N)])
'''

input()
target = [*map(int, input().split())]
temp = {x : idx for idx, x in enumerate(sorted(set(target)))}
print(*[temp[x] for x in target])
