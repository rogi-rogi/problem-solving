f = list(input().replace(" ", "").split('='))
print("YES" if eval(f[0]) == int(f[1]) else "NO")
