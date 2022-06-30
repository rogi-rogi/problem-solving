from sys import stdin
input = stdin.readline

N, M = map(int, input().split())
N_set = set(input().rstrip() for _ in range(N))
M_set = set(input().rstrip() for _ in range(M))
NM_list = sorted(list(N_set & M_set))
print(len(NM_list), *NM_list, sep = '\n')
