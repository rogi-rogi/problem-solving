from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    input()
    N = int(input())
    nums = [int(input()) for _ in range(N)]
    print(["NO", "YES"][sum(nums) % N == 0])
