temp1 = sum([*map(int, input().split())])
temp2 =  temp1 - 2 * int(input())
print([temp1, temp2][temp2 >= 0])
