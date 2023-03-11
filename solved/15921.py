N = int(input())
if N == 0:  print("divide by zero")
else:
    nums = [*map(int, input().split())]
    print("%.2f" % (sum(nums)/N / (sum(nums)/N)))
