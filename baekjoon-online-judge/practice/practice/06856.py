m = int(input())
n = int(input())

ways = 0
for i in range(1, m + 1):
    if 10 - i >= 1 and 10 - i <= n:
        ways += 1

if ways == 1:
    print("There is 1 way to get the sum 10.")
else:
    print(f"There are {ways} ways to get the sum 10.")
