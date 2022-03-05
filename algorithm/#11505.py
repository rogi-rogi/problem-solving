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
        tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD

def update(node, left, right, index, value) :
    if index < left or index > right : return
    if left == right :
        leap_nodes[index] = value
        tree[node] = value
        return
    mid = (left + right) // 2
    update(node * 2, left, mid, index, value)
    update(node * 2 + 1, mid + 1, right, index, value)
    tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD
    
def SubMol(node, left, right, sub_l, sub_r) :
    if sub_l > right or sub_r < left : return 1
    if sub_l <= left and right <= sub_r : return tree[node]
    mid = (left + right) // 2
    l_sum = SubMol(node * 2, left, mid, sub_l, sub_r)
    r_sum = SubMol(node * 2 + 1, mid + 1, right, sub_l, sub_r)
    return l_sum * r_sum % MOD
    
if __name__ == "__main__" :
    N, M, K = map(int, input().split())
    leap_nodes = [int(input()) for _ in range(N)]
    tree = [0] * (1 << (ceil(log2(N)) + 1))
    MOD = int(1e9) + 7
    initialize(1, 0, N - 1)
    for _ in range(M + K) :
        a, b, c = map(int, input().split())
        if a == 1 : update(1, 0, N - 1, b - 1, c)
        else : print(SubMol(1, 0, N - 1, b - 1, c - 1))
