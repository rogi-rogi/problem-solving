n = int(input())
print(n*(n - 1)*(n - 2)//6,  3, sep = '\n')

// view ver
arr = [i for i in range(int(input()) - 1)]
for i in range(1, len(arr)) :
    arr[i] = arr[i-1] + arr[i]
print(sum(arr), 3, sep = '\n')
