dp = [0] * 491
dp[1] = 1
for i in range(2, 491) :
    dp[i] = dp[i - 1] + dp[i - 2]
while True :
    X = int(input())
    if X == -1 : break
    print(f"Hour {X}: {dp[X]} cow(s) affected")
