res = ""
for i in list(input()) :
    res += chr(ord(i) + (23 if ord(i) < 68 else -3))
print(res)
