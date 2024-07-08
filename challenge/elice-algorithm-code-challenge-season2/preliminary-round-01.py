from itertools import permutations

N = input()
INT_N = int(N)
print(next(p for p in sorted(map(lambda p: int(''.join(p)), permutations(N))) if p > INT_N))
