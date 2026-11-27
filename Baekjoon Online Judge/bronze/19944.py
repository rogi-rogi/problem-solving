N, M = map(int, input().split())
if M <= 2 : res = "NEWBIE!"
elif M <= N : res = "OLDBIE!"
else : res = "TLE!"
print(res)
