#default ver
from sys import stdin
input = stdin.readline

def dfs(idx, depth) :
    if depth == 6 : print(*combination)
    else :
        for i in range(idx, testcase[0]) :
            combination[depth] = testcase[i + 1]
            dfs(i + 1, depth + 1)

while True :
    testcase = list(map(int, input().split()))
    if testcase[0] == 0 : break
    combination = [0] * 6
    dfs(0, 0)
    print()
    
#simple ver
from itertools import combinations
from sys import stdin
input = stdin.readline

while True :
    testcase = list(map(int, input().split()))
    if testcase[0] == 0 : break
    for i in list(combinations(testcase[1:], 6)) :
        print(*i)
    print()
