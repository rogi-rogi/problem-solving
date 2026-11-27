from math import ceil, log2
from sys import stdin
input = stdin.readline

def initialize(node, left, right) :
    if left == right :
        tree[node] = leap_nodes[left]
    else :
        mid = (left + right) // 2
        initialize(node * 2, left, mid)
        initialize(node * 2 + 1, mid + 1, right)
        tree[node] = min(tree[node * 2], tree[node * 2 + 1])
    
def query(node, left, right, sub_l, sub_r) :
    if sub_l > right or sub_r < left : return int(1e9)
    if sub_l <= left and right <= sub_r : return tree[node]
    mid = (left + right) // 2
    l_min = query(node * 2, left, mid, sub_l, sub_r)
    r_min = query(node * 2 + 1, mid + 1, right, sub_l, sub_r)
    return min(l_min, r_min)
    
if __name__ == "__main__" :
    N, M = map(int, input().split())
    leap_nodes = [int(input()) for _ in range(N)]
    tree = [0] * (1 << (ceil(log2(N)) + 1))
    initialize(1, 0, N - 1)
    for _ in range(M) :
        a, b = map(int, input().split())
        print(query(1, 0, N - 1, a - 1, b - 1))
