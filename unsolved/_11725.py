from collections import defaultdict, deque
from sys import stdin
input = stdin.readline

def BFS() :
    parents = [0] * (N + 1)
    queue = deque([1])
    find_root = 0
    while queue :
        num = queue.popleft()
        for next_num in tree[num] :
            if parents[next_num] == 0 and next_num != 1 :
                parents[next_num] = num
                queue.append(next_num)
                find_root += 1
            if find_root >= N : return parents
    return parents

if __name__ == "__main__" :
    N = int(input())
    tree = defaultdict(list)
    for _ in range(N - 1) :
        num1, num2 = map(int, input().split())
        tree[num1].append(num2)
        tree[num2].append(num1)
    print(*BFS()[2:], sep = '\n')
