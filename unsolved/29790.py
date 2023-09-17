N, U, L = map(int, input().split())
res = "Bad"
if N >= 1000 :
    res = "Good"
    if U >= 8000 or L >= 260 :
        res = "Very Good"
print(res)
