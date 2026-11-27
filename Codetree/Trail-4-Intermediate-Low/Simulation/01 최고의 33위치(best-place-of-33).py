'''
https://www.codetree.ai/missions/2/problems/best-place-of-33?&utm_source=clipboard&utm_medium=text
'''

# Input
N = int(input())
arr = [[*map(int, input().split())] for _ in range(N)]

# Solve
res = 0
for i in range(N - 2):
    for j in range(N - 2):
        cnt = 0
        for row in range(i, i + 3):
            for col in range(j, j + 3):
                if arr[row][col] == 1:
                    cnt += 1
        res = max(res, cnt)
        if res == 9:
            break

# Output
print(res)
