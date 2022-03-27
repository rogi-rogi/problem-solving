from math import ceil, log2
from sys import stdin
input = stdin.readline

def initialize(tree, node, left, right, mode) :
    if left == right :
        tree[node] = leap_nodes[left]
    else :
        mid = (left + right) // 2
        initialize(tree, node * 2, left, mid, mode)
        initialize(tree, node * 2 + 1, mid + 1, right, mode)
        if mode == 0 :  tree[node] = min(tree[node * 2], tree[node * 2 + 1])
        else :          tree[node] = max(tree[node * 2], tree[node * 2 + 1])
    
def query_min(tree, node, left, right, sub_l, sub_r) :
    if sub_l > right or sub_r < left : return int(1e9)
    if sub_l <= left and right <= sub_r : return tree[node]
    mid = (left + right) // 2
    l_min = query_min(tree, node * 2, left, mid, sub_l, sub_r)
    r_min = query_min(tree, node * 2 + 1, mid + 1, right, sub_l, sub_r)
    return min(l_min, r_min)
    
def query_max(tree, node, left, right, sub_l, sub_r) :
    if sub_l > right or sub_r < left : return 0
    if sub_l <= left and right <= sub_r : return tree[node]
    mid = (left + right) // 2
    l_max = query_max(tree, node * 2, left, mid, sub_l, sub_r)
    r_max = query_max(tree, node * 2 + 1, mid + 1, right, sub_l, sub_r)
    return max(l_max, r_max)
    
if __name__ == "__main__" :
    N, M = map(int, input().split())
    leap_nodes = [int(input()) for _ in range(N)]
    size = (1 << (ceil(log2(N)) + 1))
    min_tree = [0] * size
    max_tree = [0] * size
    initialize(min_tree, 1, 0, N - 1, 0)
    initialize(max_tree, 1, 0, N - 1, 1)
    for _ in range(M) :
        a, b = map(int, input().split())
        print(query_min(min_tree, 1, 0, N - 1, a - 1, b - 1), query_max(max_tree, 1, 0, N - 1, a - 1, b - 1))
        
