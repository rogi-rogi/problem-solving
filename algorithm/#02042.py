from math import ceil, log2
from sys import stdin
input = stdin.readline

def initialize(node, left, right) :
    if left == right :
        tree[node] = leap_nodes[left]
        return leap_nodes[left]
    mid = (left + right) // 2
    tree[node] = initialize(node * 2, left, mid) + initialize(node * 2 + 1, mid + 1, right)
    return tree[node]

def update(node, left, right, index, diff) :
    if index < left or index > right : return
    tree[node] += diff
    if left != right :
        mid = (left + right) // 2
        update(node * 2, left, mid, index, diff)
        update(node * 2 + 1, mid + 1, right, index, diff)

def SubSum(node, left, right, sub_l, sub_r) :
    if sub_l > right or sub_r < left : return 0
    if sub_l <= left and right <= sub_r : return tree[node]
    mid = (left + right) // 2
    return SubSum(node * 2, left, mid, sub_l, sub_r) + SubSum(node * 2 + 1, mid + 1, right, sub_l, sub_r)
    
if __name__ == "__main__" :
    N, M, K = map(int, input().split())
    leap_nodes = [int(input()) for _ in range(N)]
    tree = [0] * pow(2, ceil(log2(N)) + 1)
    initialize(1, 0, N - 1)
    for _ in range(M + K) :
        a, b, c = map(int, input().split())
        if a == 1 :
            diff = c - leap_nodes[b - 1]
            leap_nodes[b - 1] = c
            update(1, 0, N - 1, b - 1, diff)
        else : print(SubSum(1, 0, N - 1, b - 1, c - 1))
