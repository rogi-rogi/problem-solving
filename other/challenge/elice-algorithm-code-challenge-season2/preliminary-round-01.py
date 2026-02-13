''' 
from itertools import permutations
N = input()
INT_N = int(N)
print(next(p for p in sorted(map(lambda p: int(''.join(p)), permutations(N))) if p > INT_N))
'''

def next_permutation(arr): # len(arr) >= 2
    i = len(arr) - 1
    while i >= 0 and arr[i - 1] >= arr[i]:
        i -= 1
    # i >= 1
    
    j = len(arr) - 1
    while arr[i - 1] >= arr[j]:
        j -= 1
    
    arr[i - 1], arr[j] = arr[j], arr[i - 1]

    arr[i:] = reversed(arr[i:])
    return arr

N = [*map(int, input())]
print(*next_permutation(N), sep='')
