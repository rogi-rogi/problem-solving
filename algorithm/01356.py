N = list(map(int, input()))
size = len(N)
ans = "NO"
if size != 1 :
    for i in range(size) :
        front, back = 1, 1
        for f in N[: i + 1] : front *= f
        for b in N[i + 1 :] : back *= b
        if front == back :
            ans = "YES"
            break
print(ans)
