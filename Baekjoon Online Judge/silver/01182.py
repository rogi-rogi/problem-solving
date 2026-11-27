def dfs(x, res) :
    '''
    cnt = 0
    if res == S and x > 0 :
        cnt += 1
    for i in range(x, N) :
        if not visited[i] :
            visited[i] = True
            cnt += dfs(i + 1, res + nums[i])
            visited[i] = False
    return cnt
    '''
    cnt = 0
    if x == N :
        return [0, 1][res == S]
    cnt += dfs(x + 1, res)
    cnt += dfs(x + 1, res + nums[x])
    return cnt
    
    
if __name__ == "__main__" :
    N, S = map(int, input().split())
    nums = [*map(int, input().split())]
    # visited = [False] * N
    print(dfs(0, 0) - [0, 1][S == 0])

'''
from itertools import combinations

N, S = map(int, input().split())
nums = [*map(int, input().split())]
cnt = 0
for i in range(1, N + 1) :
    cnt += sum([1 for comb in combinations(nums, i) if sum(comb) == S])
print(cnt)
'''
